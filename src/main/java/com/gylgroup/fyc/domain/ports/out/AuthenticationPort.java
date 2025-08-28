package com.gylgroup.fyc.domain.ports.out;

import org.springframework.security.core.userdetails.UserDetails;

// Este puerto define CÓMO la aplicación se comunica con un sistema de autenticación externo.
public interface AuthenticationPort {
    // Devuelve los detalles del usuario si la autenticación es exitosa.
    // Lanza una excepción si falla.
    UserDetails authenticate(String identifier, String password);
}