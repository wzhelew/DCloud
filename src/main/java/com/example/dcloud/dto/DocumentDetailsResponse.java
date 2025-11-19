package com.example.dcloud.dto;

import java.time.LocalDate;
import java.util.List;

public class DocumentDetailsResponse {
    private final Long documentId;
    private final Long companyId;
    private final Long supplierId;
    private final LocalDate date;
    private final List<DocumentLineDetail> lines;

    public DocumentDetailsResponse(Long documentId, Long companyId, Long supplierId, LocalDate date,
                                   List<DocumentLineDetail> lines) {
        this.documentId = documentId;
        this.companyId = companyId;
        this.supplierId = supplierId;
        this.date = date;
        this.lines = lines;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<DocumentLineDetail> getLines() {
        return lines;
    }
}
