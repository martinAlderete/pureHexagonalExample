package com.gylgroup.fyc.domain.ports.out;

import com.gylgroup.fyc.domain.models.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProviderModelPort {

    Provider save(Provider provider);

    Optional<Provider> findById(Long id);

    Page<Provider> findAll(Pageable pageable, String searchTerm);

    boolean existsByCuit(String cuit);

    boolean existsByEmail(String email);



}
