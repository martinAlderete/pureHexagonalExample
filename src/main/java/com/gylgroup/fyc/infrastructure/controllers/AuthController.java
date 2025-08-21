package com.gylgroup.fyc.infrastructure.controllers;

import com.gylgroup.fyc.application.auth.dto.LoginRequest;
import com.gylgroup.fyc.application.auth.dto.LoginResponse;
import com.gylgroup.fyc.application.auth.port.in.LoginUseCase;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = loginUseCase.login(loginRequest);
            // Este log solo se mostrará si todo el proceso fue exitoso
            System.out.println("Login exitoso para: " + loginRequest.getIdentifier());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Este bloque captura cualquier error inesperado durante el login
            System.err.println("Error durante el login para: " + loginRequest.getIdentifier());
            // La siguiente línea es clave para depurar: imprime el error detallado en la consola
            e.printStackTrace();
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }
}