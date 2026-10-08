package com.pieldecabra.backend.service;

import org.springframework.stereotype.Service;

import com.pieldecabra.backend.entity.Documental;
import com.pieldecabra.backend.repository.DocumentalRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class PagoService {

    private final DocumentalRepository documentalRepository;

    public PagoService(DocumentalRepository documentalRepository) {
        this.documentalRepository = documentalRepository;
    }

    public String crearCheckout(Long idDocumental) throws StripeException{
        Documental documental = documentalRepository.findById(idDocumental).orElseThrow(() -> new RuntimeException("Documental no encontrado"));
        long precio = 1500;
        SessionCreateParams params = SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl("http://localhost:4200/pago-exitoso")
                .setCancelUrl("http://localhost:4200/pago-cancelado").addLineItem(SessionCreateParams.LineItem.builder().setQuantity(1L)
                .setPriceData(SessionCreateParams.LineItem.PriceData.builder().setCurrency("eur").setUnitAmount(precio)
                        .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder().setName(documental.getTitulo()).build()).build())
                .build()).build();
        Session session=Session.create(params);
        return session.getUrl();
    }
}
