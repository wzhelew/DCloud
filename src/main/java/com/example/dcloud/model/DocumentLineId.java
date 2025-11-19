package com.example.dcloud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DocumentLineId implements Serializable {

    @Column(name = "document_id")
    private Long documentId;

    @Column(name = "item_code")
    private String itemCode;

    public DocumentLineId() {
    }

    public DocumentLineId(Long documentId, String itemCode) {
        this.documentId = documentId;
        this.itemCode = itemCode;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentLineId that)) return false;
        return Objects.equals(documentId, that.documentId) && Objects.equals(itemCode, that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, itemCode);
    }
}
