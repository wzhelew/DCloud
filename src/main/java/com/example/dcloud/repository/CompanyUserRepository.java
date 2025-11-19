package com.example.dcloud.repository;

import com.example.dcloud.model.CompanyUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUser, Long> {
    Optional<CompanyUser> findByUsernameAndPassword(String username, String password);
}
