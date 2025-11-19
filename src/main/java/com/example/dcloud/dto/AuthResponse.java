package com.example.dcloud.dto;

public class AuthResponse {
    private boolean valid;
    private Long companyId;
    private String companyName;

    public AuthResponse(boolean valid, Long companyId, String companyName) {
        this.valid = valid;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
