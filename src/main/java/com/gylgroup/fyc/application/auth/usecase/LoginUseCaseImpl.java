package com.gylgroup.fyc.application.auth.usecase;

import com.gylgroup.fyc.application.auth.dto.LoginRequest;
import com.gylgroup.fyc.application.auth.dto.LoginResponse;
import com.gylgroup.fyc.application.auth.port.in.LoginUseCase;
import com.gylgroup.fyc.domain.ports.out.JwtTokenProviderPort;
import com.gylgroup.fyc.infrastructure.security.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCaseImpl implements LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProviderPort jwtTokenProviderPort;

    public LoginUseCaseImpl(AuthenticationManager authenticationManager, JwtTokenProviderPort jwtTokenProviderPort) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProviderPort = jwtTokenProviderPort;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getIdentifier(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // El puerto JwtTokenProviderPort debe ser ajustado para recibir UserDetailsImpl
        String token = jwtTokenProviderPort.generateToken(userDetails);

        return new LoginResponse(token);
    }
}