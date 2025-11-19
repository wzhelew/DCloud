package com.example.dcloud.dto;

public class LoginResponse {
    private final boolean valid;
    private final String message;

    public LoginResponse(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }
}
