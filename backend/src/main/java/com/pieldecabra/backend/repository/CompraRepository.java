package com.pieldecabra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pieldecabra.backend.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    boolean existsByCodigo(String codigo);
    boolean existsByStripeSessionId(String stripeSessionId);
}
