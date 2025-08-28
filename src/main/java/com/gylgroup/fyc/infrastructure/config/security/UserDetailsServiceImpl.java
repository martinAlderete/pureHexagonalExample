// En: src/main/java/com/gylgroup/fyc/infrastructure/security/UserDetailsServiceImpl.java

package com.gylgroup.fyc.infrastructure.config.security;

import com.gylgroup.fyc.infrastructure.entities.UserEntity;
import com.gylgroup.fyc.infrastructure.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(identifier)
                .or(() -> userRepository.findByCuit(identifier))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el identificador: " + identifier));

        // Envolvemos la entidad encontrada (sea Proveedor o Empleado) en nuestro adaptador.
        return new UserDetailsImpl(userEntity);
    }
}