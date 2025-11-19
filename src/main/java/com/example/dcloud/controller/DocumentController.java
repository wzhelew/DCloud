package com.example.dcloud.controller;

import com.example.dcloud.dto.DocumentDetailsResponse;
import com.example.dcloud.dto.DocumentSummaryResponse;
import com.example.dcloud.dto.LoginRequest;
import com.example.dcloud.dto.LoginResponse;
import com.example.dcloud.service.DocumentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        boolean valid = documentService.validateLogin(request.getUsername(), request.getPassword());
        String message = valid ? "Успешен вход" : "Невалидни данни";
        return new LoginResponse(valid, message);
    }

    @GetMapping("/documents")
    public List<DocumentSummaryResponse> getDocuments(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Крайна дата трябва да е след начална дата");
        }
        return documentService.getDocumentsBetween(startDate, endDate);
    }

    @GetMapping("/documents/{documentId}")
    public ResponseEntity<DocumentDetailsResponse> getDocument(@PathVariable Long documentId) {
        return documentService.getDocumentDetails(documentId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
