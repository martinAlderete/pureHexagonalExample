package com.gylgroup.fyc.infrastructure.services;

import com.gylgroup.fyc.domain.ports.out.AuthenticationPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationPortImpl implements AuthenticationPort {

    private final AuthenticationManager authenticationManager;

    public AuthenticationPortImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails authenticate(String identifier, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(identifier, password)
        );
        return (UserDetails) authentication.getPrincipal();
    }
}