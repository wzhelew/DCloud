package com.example.dcloud.dto;

import java.time.LocalDate;
import java.util.List;

public class DocumentDetailDto {
    private Long id;
    private String companyName;
    private String supplierName;
    private LocalDate documentDate;
    private List<DocumentItemDto> items;

    public DocumentDetailDto(Long id, String companyName, String supplierName, LocalDate documentDate, List<DocumentItemDto> items) {
        this.id = id;
        this.companyName = companyName;
        this.supplierName = supplierName;
        this.documentDate = documentDate;
        this.items = items;
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

    public List<DocumentItemDto> getItems() {
        return items;
    }

    public void setItems(List<DocumentItemDto> items) {
        this.items = items;
    }
}
