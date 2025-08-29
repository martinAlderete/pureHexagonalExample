package com.gylgroup.fyc.infrastructure.adapters;

import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import com.gylgroup.fyc.infrastructure.entities.ProviderEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleName;
import com.gylgroup.fyc.infrastructure.mappers.ProviderDboMapper;
import com.gylgroup.fyc.infrastructure.repositories.ProviderRepository;
import com.gylgroup.fyc.infrastructure.repositories.RoleRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProviderAdapter implements ProviderModelPort {

    private final ProviderRepository providerRepository;
    private final ProviderDboMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public ProviderAdapter(ProviderRepository providerRepository, ProviderDboMapper mapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.providerRepository = providerRepository;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Provider save(Provider provider) {
        ProviderEntity entity = mapper.toEntity(provider);
        if (entity.getId() == null) {
            String tempPassword = UUID.randomUUID().toString().substring(0, 8);
            entity.setPassword(passwordEncoder.encode(tempPassword));
            System.out.println("Contraseña temporal para " + entity.getEmail() + ": " + tempPassword);
            RoleEntity role = roleRepository.findByName(RoleName.PROVEEDOR)
                    .orElseThrow(() -> new RuntimeException("Error: Rol PROVEEDOR no encontrado."));
            entity.setRole(role);
            entity.setCreationDate(LocalDateTime.now());
        }
        ProviderEntity savedEntity = providerRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Provider> findAll(Pageable pageable, String searchTerm) {
        Page<ProviderEntity> entityPage;
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            entityPage = providerRepository.findAll(pageable);
        } else {
            entityPage = providerRepository.findAllFiltered(pageable, searchTerm);
        }
        return entityPage.map(mapper::toDomain);
    }

    @Override
    public boolean existsByCuit(String cuit) {
        return providerRepository.existsByCuit(cuit);
    }

    @Override
    public boolean existsByEmail(String email) {
        return providerRepository.existsByEmail(email);
    }
}