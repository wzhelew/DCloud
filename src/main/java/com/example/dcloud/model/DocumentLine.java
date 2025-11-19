package com.example.dcloud.model;

import java.math.BigDecimal;

public class DocumentLine {
    private final Long documentId;
    private final String productCode;
    private final int quantity;
    private final BigDecimal price;

    public DocumentLine(Long documentId, String productCode, int quantity, BigDecimal price) {
        this.documentId = documentId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
