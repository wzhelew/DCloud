package com.example.dcloud.dto;

import java.time.LocalDate;

public class DocumentSummaryResponse {
    private final Long documentId;
    private final Long companyId;
    private final Long supplierId;
    private final LocalDate date;

    public DocumentSummaryResponse(Long documentId, Long companyId, Long supplierId, LocalDate date) {
        this.documentId = documentId;
        this.companyId = companyId;
        this.supplierId = supplierId;
        this.date = date;
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
}
