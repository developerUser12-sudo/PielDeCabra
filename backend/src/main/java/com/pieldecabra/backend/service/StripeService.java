package com.pieldecabra.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;

import jakarta.annotation.PostConstruct;

@Service
public class StripeService {

    @Value("${stripe.secret-key}")
    private String secretKey;

    @PostConstruct
    public void configurarStripe() {
        Stripe.apiKey=secretKey;
    }
}
