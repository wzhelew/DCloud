package com.example.dcloud.model;

import java.time.LocalDate;

public class Document {
    private final Long id;
    private final Long companyId;
    private final Long supplierId;
    private final LocalDate date;

    public Document(Long id, Long companyId, Long supplierId, LocalDate date) {
        this.id = id;
        this.companyId = companyId;
        this.supplierId = supplierId;
        this.date = date;
    }

    public Long getId() {
        return id;
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
