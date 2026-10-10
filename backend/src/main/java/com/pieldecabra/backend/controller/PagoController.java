package com.pieldecabra.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pieldecabra.backend.service.CompraService;
import com.pieldecabra.backend.service.PagoService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;
    @Value("${stripe.webhook-secret}")
    private String webhookSecret;
    private final CompraService compraService;

    public PagoController(PagoService pagoService, CompraService compraService) {
        this.pagoService = pagoService;
        this.compraService = compraService;
    }

    @PostMapping("/crear-checkout")
    public ResponseEntity<?> crearCheckout(@RequestBody PagoRequest request) {
        try {
            String url = pagoService.crearCheckout(request.idPlan(), request.correo());
            return ResponseEntity.ok(new CheckoutResponse(url));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (StripeException e) {
            return ResponseEntity.internalServerError().body("No se ha podido iniciar el pago");
        }

    }

    @PostMapping("/webhook")
    public ResponseEntity<String> recibirWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String firma) {
        Event evento;
        try {
            evento = Webhook.constructEvent(payload, firma, webhookSecret);
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Firma del webhook no válida");
        }

        if ("checkout.session.completed".equals(evento.getType())) {

            Optional<Session> sesionOpcional = evento.getDataObjectDeserializer().getObject().filter(Session.class::isInstance).map(Session.class::cast);
            if (sesionOpcional.isEmpty()) {
                return ResponseEntity.badRequest().body("No se ha podido obtener la sesión de Stripe");
            }

            Session sesion = sesionOpcional.get();
            if (!"paid".equals(sesion.getPaymentStatus())) {
                return ResponseEntity.ok("Pago todavía no confirmado");
            }

            if (sesion.getMetadata() == null) {
                return ResponseEntity.badRequest().body("Faltan los datos de la compra");
            }

            String idPlanTexto = sesion.getMetadata().get("idPlan");
            String correo = sesion.getMetadata().get("email");
            if (idPlanTexto == null || correo == null || idPlanTexto.isBlank() || correo.isBlank()) {
                return ResponseEntity.badRequest().body("Faltan los datos de la compra");
            }

            try {
                Long idPlan = Long.valueOf(idPlanTexto);
                compraService.registrarCompra(idPlan, correo, sesion.getId());

                System.out.println("Compra procesada: " + sesion.getId());

            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body("El identificador del plan no es válido");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Plan no válido");
            }
        }
        return ResponseEntity.ok("Evento recibido");
    }

    public record PagoRequest(Long idPlan, String correo) {

    }

    public record CheckoutResponse(String url) {

    }
}
