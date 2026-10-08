package com.pieldecabra.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pieldecabra.backend.entity.Documental;
import com.pieldecabra.backend.service.DocumentalService;

@RestController
@RequestMapping("/api/admin/documentales")

public class DocumentalController {

    private final DocumentalService documentalService;

    public DocumentalController(DocumentalService documentalService) {
        this.documentalService = documentalService;
    }
    @PostMapping
    public ResponseEntity<Documental> crearDocumental(@RequestBody Documental documental){
        Documental documentalCreado=documentalService.crearDocumental(documental);
        return ResponseEntity.ok(documentalCreado);
    }
}
