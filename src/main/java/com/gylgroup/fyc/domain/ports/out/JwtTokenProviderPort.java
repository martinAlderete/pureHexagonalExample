package com.gylgroup.fyc.domain.ports.out;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtTokenProviderPort {

    String generateToken(UserDetails userDetails);
}