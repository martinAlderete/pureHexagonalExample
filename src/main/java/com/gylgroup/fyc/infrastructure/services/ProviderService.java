package com.gylgroup.fyc.infrastructure.services;

import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import com.gylgroup.fyc.infrastructure.entities.ProviderEntity;
import com.gylgroup.fyc.infrastructure.mappers.ProviderDboMapper;
import com.gylgroup.fyc.infrastructure.repositories.ProviderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Opcional, pero común en la capa de servicio

import java.util.Optional;

@Service // Anotamos como Service
public class ProviderService implements ProviderModelPort {

    private final ProviderRepository providerRepository;
    private final ProviderDboMapper mapper;

    public ProviderService(ProviderRepository providerRepository, ProviderDboMapper mapper) {
        this.providerRepository = providerRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional // Ejemplo de cómo usarías la capa de servicio para manejar transacciones
    public Provider save(Provider provider) {
        ProviderEntity entity = mapper.toEntity(provider);
        ProviderEntity savedEntity = providerRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public boolean existsByCuit(String cuit) {
        return providerRepository.existsByCuit(cuit);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return providerRepository.existsByEmail(email);
    }
}