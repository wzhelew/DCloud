package com.example.dcloud.service;

import com.example.dcloud.dto.DocumentDetailsResponse;
import com.example.dcloud.dto.DocumentLineDetail;
import com.example.dcloud.dto.DocumentSummaryResponse;
import com.example.dcloud.model.Company;
import com.example.dcloud.model.Document;
import com.example.dcloud.model.DocumentLine;
import com.example.dcloud.model.Product;
import com.example.dcloud.model.Supplier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final Map<Long, Company> companies = new HashMap<>();
    private final Map<Long, Supplier> suppliers = new HashMap<>();
    private final Map<Long, Document> documents = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();
    private final List<DocumentLine> documentLines = new ArrayList<>();

    public DocumentService() {
        seedData();
    }

    private void seedData() {
        companies.put(1L, new Company(1L, "Tech OOD", "tech", "secret"));
        companies.put(2L, new Company(2L, "Food AD", "food", "taste"));

        suppliers.put(10L, new Supplier(10L, "Fresh Supplies"));
        suppliers.put(20L, new Supplier(20L, "Electro Import"));

        products.put("P-100", new Product(100L, "380000000001", "P-100", "USB Cable", 1000L));
        products.put("P-200", new Product(200L, "380000000002", "P-200", "Keyboard", 1001L));
        products.put("P-300", new Product(300L, "380000000003", "P-300", "Apples 1kg", 1002L));

        documents.put(500L, new Document(500L, 1L, 20L, LocalDate.now().minusDays(2)));
        documents.put(501L, new Document(501L, 1L, 10L, LocalDate.now().minusDays(1)));
        documents.put(502L, new Document(502L, 2L, 10L, LocalDate.now()));

        documentLines.add(new DocumentLine(500L, "P-100", 10, new BigDecimal("5.90")));
        documentLines.add(new DocumentLine(500L, "P-200", 5, new BigDecimal("18.50")));
        documentLines.add(new DocumentLine(501L, "P-300", 30, new BigDecimal("2.20")));
        documentLines.add(new DocumentLine(502L, "P-300", 50, new BigDecimal("2.05")));
        documentLines.add(new DocumentLine(502L, "P-100", 15, new BigDecimal("5.70")));
    }

    public boolean validateLogin(String username, String password) {
        return companies.values().stream()
                .anyMatch(company -> company.getUsername().equalsIgnoreCase(username)
                        && company.getPassword().equals(password));
    }

    public List<DocumentSummaryResponse> getDocumentsBetween(LocalDate startDate, LocalDate endDate) {
        return documents.values().stream()
                .filter(doc -> !doc.getDate().isBefore(startDate) && !doc.getDate().isAfter(endDate))
                .sorted(Comparator.comparing(Document::getDate))
                .map(doc -> new DocumentSummaryResponse(doc.getId(), doc.getCompanyId(), doc.getSupplierId(), doc.getDate()))
                .collect(Collectors.toList());
    }

    public Optional<DocumentDetailsResponse> getDocumentDetails(Long documentId) {
        Document document = documents.get(documentId);
        if (document == null) {
            return Optional.empty();
        }

        List<DocumentLineDetail> lineDetails = documentLines.stream()
                .filter(line -> line.getDocumentId().equals(documentId))
                .map(line -> {
                    Product product = products.get(line.getProductCode());
                    String name = product != null ? product.getName() : "Unknown";
                    String barcode = product != null ? product.getBarcode() : "";
                    return new DocumentLineDetail(line.getProductCode(), name, barcode, line.getQuantity(), line.getPrice());
                })
                .collect(Collectors.toList());

        return Optional.of(new DocumentDetailsResponse(
                document.getId(),
                document.getCompanyId(),
                document.getSupplierId(),
                document.getDate(),
                lineDetails
        ));
    }
}
