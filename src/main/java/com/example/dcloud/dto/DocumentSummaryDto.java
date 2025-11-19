package com.example.dcloud.dto;

import java.time.LocalDate;

public class DocumentSummaryDto {
    private Long id;
    private String companyName;
    private String supplierName;
    private LocalDate documentDate;

    public DocumentSummaryDto(Long id, String companyName, String supplierName, LocalDate documentDate) {
        this.id = id;
        this.companyName = companyName;
        this.supplierName = supplierName;
        this.documentDate = documentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }
}
