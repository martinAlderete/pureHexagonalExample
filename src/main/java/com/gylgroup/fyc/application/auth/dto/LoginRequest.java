package com.gylgroup.fyc.application.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "El identificador no puede estar vacío.")
    private String identifier;

    @NotBlank(message = "La contraseña no puede estar vacía.")
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
