package com.example.dcloud.dto;

import java.math.BigDecimal;

public class DocumentItemDto {
    private String code;
    private String name;
    private String barcode;
    private BigDecimal quantity;
    private BigDecimal price;

    public DocumentItemDto(String code, String name, String barcode, BigDecimal quantity, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.barcode = barcode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
