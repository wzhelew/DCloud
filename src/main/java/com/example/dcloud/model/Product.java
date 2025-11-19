package com.example.dcloud.model;

public class Product {
    private final Long id;
    private final String barcode;
    private final String code;
    private final String name;
    private final Long baseId;

    public Product(Long id, String barcode, String code, String name, Long baseId) {
        this.id = id;
        this.barcode = barcode;
        this.code = code;
        this.name = name;
        this.baseId = baseId;
    }

    public Long getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Long getBaseId() {
        return baseId;
    }
}
