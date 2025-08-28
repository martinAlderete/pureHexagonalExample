package com.gylgroup.fyc.infrastructure.services;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.application.provider.createProvider.mapper.CreateProviderMapper;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.application.provider.getAllProviders.dto.ProviderSummaryResponse;
import com.gylgroup.fyc.application.provider.getAllProviders.mapper.GetAllProvidersMapper;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.domain.models.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    private final CreateProvider createProvider;
    private final DeactivateProvider deactivateProvider;
    private final GetAllProviders getAllProviders;
    private final CreateProviderMapper createMapper;
    private final GetAllProvidersMapper getAllMapper;

    public ProviderService(CreateProvider createProvider, DeactivateProvider deactivateProvider, GetAllProviders getAllProviders, CreateProviderMapper createMapper, GetAllProvidersMapper getAllMapper) {
        this.createProvider = createProvider;
        this.deactivateProvider = deactivateProvider;
        this.getAllProviders = getAllProviders;
        this.createMapper = createMapper;
        this.getAllMapper = getAllMapper;
    }

    public CreateProviderResponse createProvider(CreateProviderRequest createProviderRequest) {
        Provider domainProvider = createMapper.toDomain(createProviderRequest);
        Provider createdProvider = createProvider.createProvider(domainProvider);
        return createMapper.toResponse(createdProvider);
    }

    public boolean deactivateProvider(Long id) {
        return deactivateProvider.deactivate(id);
    }

    public Page<ProviderSummaryResponse> getAllProviders(Pageable pageable, String searchTerm) {
        Page<Provider> providerPage = getAllProviders.findAll(pageable, searchTerm);
        return providerPage.map(getAllMapper::toResponse);
    }
}