package com.pieldecabra.backend.service;

import org.springframework.stereotype.Service;

import com.pieldecabra.backend.entity.Plan;
import com.pieldecabra.backend.repository.PlanRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class PagoService {

    private final PlanRepository planRepository;

    public PagoService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public String crearCheckout(Long idPlan, String email) throws StripeException {
        Plan plan = planRepository.findById(idPlan).orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));
        long precioEnCentimos = plan.getPrecio().movePointRight(2).longValueExact();
        SessionCreateParams params = SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT).setCustomerEmail(email)
                .setSuccessUrl("http://localhost:4200/pago-exitoso?session_id={CHECKOUT_SESSION_ID}").setCancelUrl("http://localhost:4200/pago-cancelado")
                .addLineItem(SessionCreateParams.LineItem.builder().setQuantity(1L).setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency("eur").setUnitAmount(precioEnCentimos).setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(plan.getNombre()).build()).build()).build()).putMetadata("idPlan", String.valueOf(idPlan)).putMetadata("email", email).build();
        Session session = Session.create(params);

        return session.getUrl();
    }
}
