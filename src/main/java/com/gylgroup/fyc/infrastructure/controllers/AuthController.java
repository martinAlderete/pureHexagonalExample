package com.gylgroup.fyc.infrastructure.controllers;

import com.gylgroup.fyc.application.auth.dto.LoginRequest;
import com.gylgroup.fyc.application.auth.dto.LoginResponse;
import com.gylgroup.fyc.application.auth.port.in.LoginUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        // La lógica de validación ya no está aquí.
        // Si la validación falla, el GlobalExceptionHandler tomará el control.
        try {
            LoginResponse response = loginUseCase.login(loginRequest);
            System.out.println("Login exitoso para: " + loginRequest.getIdentifier());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            System.err.println("Fallo el intento de login para: " + loginRequest.getIdentifier());
            return ResponseEntity.status(401).body(null);
        }
    }
}