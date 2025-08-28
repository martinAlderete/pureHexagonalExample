package com.gylgroup.fyc.infrastructure.factory;

import com.gylgroup.fyc.application.auth.port.in.LoginUseCase;
import com.gylgroup.fyc.application.auth.usecase.LoginUseCaseImpl;
import com.gylgroup.fyc.domain.ports.out.AuthenticationPort;
import com.gylgroup.fyc.domain.ports.out.JwtTokenProviderPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginUseCaseFactory {

    @Bean
    public LoginUseCase loginUseCase(AuthenticationPort authenticationPort,
                                     JwtTokenProviderPort jwtTokenProviderPort) {
        return new LoginUseCaseImpl(authenticationPort, jwtTokenProviderPort);
    }
}