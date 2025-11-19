package com.example.dcloud.service;

import com.example.dcloud.dto.DocumentDetailDto;
import com.example.dcloud.dto.DocumentItemDto;
import com.example.dcloud.dto.DocumentSummaryDto;
import com.example.dcloud.model.Document;
import com.example.dcloud.model.DocumentLine;
import com.example.dcloud.repository.DocumentRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<DocumentSummaryDto> findDocuments(LocalDate from, LocalDate to) {
        return documentRepository.findByDocumentDateBetween(from, to).stream()
                .map(document -> new DocumentSummaryDto(
                        document.getId(),
                        document.getCompany().getCompanyName(),
                        document.getSupplier().getName(),
                        document.getDocumentDate()))
                .toList();
    }

    @Transactional(readOnly = true)
    public DocumentDetailDto getDocument(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Document not found: " + id));

        List<DocumentItemDto> items = document.getLines().stream()
                .map(this::mapLine)
                .collect(Collectors.toList());

        return new DocumentDetailDto(
                document.getId(),
                document.getCompany().getCompanyName(),
                document.getSupplier().getName(),
                document.getDocumentDate(),
                items);
    }

    private DocumentItemDto mapLine(DocumentLine line) {
        return new DocumentItemDto(
                line.getItem().getCode(),
                line.getItem().getName(),
                line.getItem().getBarcode(),
                line.getQuantity(),
                line.getPrice());
    }
}
