package com.pieldecabra.backend.service;

import org.springframework.stereotype.Service;

import com.pieldecabra.backend.entity.Documental;
import com.pieldecabra.backend.repository.DocumentalRepository;
@Service
public class DocumentalService {

    private final DocumentalRepository repo;

    public DocumentalService(DocumentalRepository repo) {
        this.repo = repo;
    }

    public Documental crearDocumental(Documental documental){
        return repo.save(documental);
    }
}
