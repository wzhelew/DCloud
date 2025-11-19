package com.example.dcloud.dto;

import java.math.BigDecimal;

public class DocumentLineDetail {
    private final String code;
    private final String name;
    private final String barcode;
    private final int quantity;
    private final BigDecimal price;

    public DocumentLineDetail(String code, String name, String barcode, int quantity, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
