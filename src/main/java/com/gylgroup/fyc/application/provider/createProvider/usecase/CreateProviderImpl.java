package com.gylgroup.fyc.application.provider.createProvider.usecase;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.application.provider.createProvider.mapper.CreateProviderMapper;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.models.Role;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import com.gylgroup.fyc.infrastructure.entities.RoleEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleName;
import com.gylgroup.fyc.infrastructure.repositories.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Set;

public class CreateProviderImpl implements CreateProvider {

    private final ProviderModelPort providerModelPort;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // ==========================================
    // ESTE ES EL CONSTRUCTOR QUE FALTA
    // ==========================================
    // Porqué: Este constructor le permite a la clase recibir y guardar
    // las "herramientas" que la Factory le pasa. Sin esto, la clase no
    // sabe cómo aceptar las dependencias.
    public CreateProviderImpl(
            ProviderModelPort providerModelPort,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.providerModelPort = providerModelPort;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CreateProviderResponse createProvider(CreateProviderRequest request) {
        if (providerModelPort.existsByCuit(request.getCuit())) {
            throw new IllegalStateException("El CUIT ya está registrado.");
        }
        if (providerModelPort.existsByEmail(request.getEmail())) {
            throw new IllegalStateException("El email ya está registrado.");
        }

        RoleEntity roleEntity = roleRepository.findByName(RoleName.PROVEEDOR)
                .orElseThrow(() -> new RuntimeException("Rol PROVEEDOR no encontrado."));
        Role role = new Role(roleEntity.getId(), roleEntity.getName().name());

        Provider newProvider = new Provider(
                null,
                passwordEncoder.encode("changeit"),
                request.getEmail(),
                Set.of(role),
                true,
                LocalDateTime.now(),
                true, true, true,
                request.getCuit(),
                request.getCompanyName(),
                request.getAddress(),
                request.getPhone(),
                true,
                null,
                null
        );

        Provider savedProvider = providerModelPort.save(newProvider);
        return CreateProviderMapper.toResponse(savedProvider);
    }
}