package com.example.dcloud.service;

import com.example.dcloud.dto.AuthRequest;
import com.example.dcloud.dto.AuthResponse;
import com.example.dcloud.model.CompanyUser;
import com.example.dcloud.repository.CompanyUserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final CompanyUserRepository companyUserRepository;

    public AuthService(CompanyUserRepository companyUserRepository) {
        this.companyUserRepository = companyUserRepository;
    }

    public AuthResponse authenticate(AuthRequest request) {
        Optional<CompanyUser> user = companyUserRepository
                .findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user.isPresent()) {
            CompanyUser companyUser = user.get();
            return new AuthResponse(true, companyUser.getId(), companyUser.getCompanyName());
        }
        return new AuthResponse(false, null, null);
    }
}
