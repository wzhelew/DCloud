package com.example.dcloud.repository;

import com.example.dcloud.model.Document;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByDocumentDateBetween(LocalDate from, LocalDate to);
}
