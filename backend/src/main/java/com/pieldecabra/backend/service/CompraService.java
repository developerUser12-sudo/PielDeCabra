package com.pieldecabra.backend.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.pieldecabra.backend.entity.Compra;
import com.pieldecabra.backend.entity.Plan;
import com.pieldecabra.backend.repository.CompraRepository;
import com.pieldecabra.backend.repository.PlanRepository;

import jakarta.transaction.Transactional;

@Service
public class CompraService {

    private static final String CARACTERES = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private final SecureRandom random = new SecureRandom();
    private final CompraRepository compraRepository;
    private final PlanRepository planRepository;

    public CompraService(CompraRepository compraRepository, PlanRepository planRepository) {
        this.compraRepository = compraRepository;
        this.planRepository = planRepository;
    }

    @Transactional
    public Compra registrarCompra(Long idPlan, String correo, String stripeSessionId) {
        if (compraRepository.existsByStripeSessionId(stripeSessionId)) {
            return null;
        }
        Plan plan = planRepository.findById(idPlan).orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));
        Compra compra = new Compra();
        compra.setPlan(plan);
        compra.setEmail(correo.trim().toLowerCase(Locale.ROOT));
        compra.setCodigo(generarCodigo());
        compra.setVisionadosRestantes(plan.getVisionados());
        compra.setStripeSessionId(stripeSessionId);
        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    private String generarCodigo() {
        String codigo;
        do {
            StringBuilder sb = new StringBuilder("PC-");
            for (int i = 0; i < 8; i++) {
                sb.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
            }
            codigo = sb.toString();
        } while (compraRepository.existsByCodigo(codigo));
        return codigo;
    }
}
