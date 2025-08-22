package com.gylgroup.fyc.application.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size; // <-- Nuevo import

public class LoginRequest {

    // Cambiamos @NotBlank por una validación de tamaño mínimo
    @Size(min = 1, message = "El identificador no puede estar vacío.")
    private String identifier;

    @Size(min = 1, message = "La contraseña no puede estar vacía.")
    private String password;

    // --- Getters y Setters ---
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