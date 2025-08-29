package com.gylgroup.fyc.infrastructure.services;

import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import com.gylgroup.fyc.infrastructure.repositories.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * ==========================================
 * EL WRAPPER / COLECTOR DE DEPENDENCIAS
 * ==========================================
 * Porqué: Esta es la única clase que habla con Spring para esta funcionalidad.
 * Su única responsabilidad es recolectar todas las dependencias (los "ingredientes")
 * que la Factory necesitará para construir nuestros casos de uso.
 * No contiene NINGUNA lógica de negocio.
 */
@Service
public class ProviderService {

    public final ProviderModelPort providerModelPort;
    public final RoleRepository roleRepository;
    public final PasswordEncoder passwordEncoder;

    // A través del constructor, le pide a Spring las "herramientas" que necesita.
    public ProviderService(
            ProviderModelPort providerModelPort,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.providerModelPort = providerModelPort;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
}