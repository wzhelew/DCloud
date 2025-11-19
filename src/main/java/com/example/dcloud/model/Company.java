package com.example.dcloud.model;

public class Company {
    private final Long id;
    private final String companyName;
    private final String username;
    private final String password;

    public Company(Long id, String companyName, String username, String password) {
        this.id = id;
        this.companyName = companyName;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
