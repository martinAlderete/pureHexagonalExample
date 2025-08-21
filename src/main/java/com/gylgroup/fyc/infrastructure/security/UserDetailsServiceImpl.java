package com.gylgroup.fyc.infrastructure.security;

import com.gylgroup.fyc.infrastructure.entities.UserEntity;
import com.gylgroup.fyc.infrastructure.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // MUY IMPORTANTE: Le dice a Spring que esto es un servicio (un Bean)
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca al usuario en la base de datos por su email (que usamos como username)
        UserEntity userEntity = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + username));

        // Envuelve la entidad de la base de datos en nuestra clase UserDetailsImpl
        return new UserDetailsImpl(userEntity);
    }
}