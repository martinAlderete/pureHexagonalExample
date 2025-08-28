package com.gylgroup.fyc.application.auth.usecase;

import com.gylgroup.fyc.application.auth.dto.LoginRequest;
import com.gylgroup.fyc.application.auth.dto.LoginResponse;
import com.gylgroup.fyc.application.auth.port.in.LoginUseCase;
import com.gylgroup.fyc.domain.ports.out.AuthenticationPort; // <-- Nueva dependencia
import com.gylgroup.fyc.domain.ports.out.JwtTokenProviderPort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class LoginUseCaseImpl implements LoginUseCase {

    private final AuthenticationPort authenticationPort;
    private final JwtTokenProviderPort jwtTokenProviderPort;

    public LoginUseCaseImpl(AuthenticationPort authenticationPort, JwtTokenProviderPort jwtTokenProviderPort) {
        this.authenticationPort = authenticationPort;
        this.jwtTokenProviderPort = jwtTokenProviderPort;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // 1. La lógica de autenticación ahora se delega a nuestro puerto.
        UserDetails userDetails = authenticationPort.authenticate(
                loginRequest.getIdentifier(),
                loginRequest.getPassword()
        );


        // 2. Generamos el token usando los detalles del usuario autenticado.
        String token = jwtTokenProviderPort.generateToken(userDetails);

        return new LoginResponse(token);
    }
}