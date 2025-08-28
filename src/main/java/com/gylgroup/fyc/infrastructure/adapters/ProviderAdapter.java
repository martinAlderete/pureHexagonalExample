package com.gylgroup.fyc.infrastructure.adapters;

import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ProviderAdapter implements ProviderModelPort {



    @Override
    public Provider save(Provider provider) {
        return null;
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Provider> findAll(Pageable pageable, String searchTerm) {
        return null;
    }

    @Override
    public boolean existsByCuit(String cuit) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
