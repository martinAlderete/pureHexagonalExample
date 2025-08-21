package com.gylgroup.fyc.application.auth.dto;


public class LoginRequest {
    private String identifier; // Puede ser email o CUIT
    private String password;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}