package com.gylgroup.fyc.infrastructure.services;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.application.provider.getAllProviders.dto.ProviderSummaryResponse;
import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderRequest;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.port.in.UpdateProvider;
import com.gylgroup.fyc.domain.models.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderService {

    //depende de las interfaces de los Casos de Uso
    private final CreateProvider createProviderUseCase;
    private final UpdateProvider updateProviderUseCase;
    private final GetAllProviders getAllProvidersUseCase;
    private final DeactivateProvider deactivateProviderUseCase;

    // inyeccion de dependencias de los Casos de Uso
    public ProviderService(
            CreateProvider createProviderUseCase,
            UpdateProvider updateProviderUseCase,
            GetAllProviders getAllProvidersUseCase,
            DeactivateProvider deactivateProviderUseCase) {
        this.createProviderUseCase = createProviderUseCase;
        this.updateProviderUseCase = updateProviderUseCase;
        this.getAllProvidersUseCase = getAllProvidersUseCase;
        this.deactivateProviderUseCase = deactivateProviderUseCase;
    }

    // metodo publico que es llamado por el Controller
    @Transactional
    public CreateProviderResponse createProvider(CreateProviderRequest request) {

        return createProviderUseCase.createProvider(request);
    }

    @Transactional
    public UpdateProviderResponse updateProvider(Long id, UpdateProviderRequest request) {
        return updateProviderUseCase.update(id, request);
    }


    @Transactional(readOnly = true)
    public Page<Provider> getAllProviders(Pageable pageable, String searchTerm) {
        return getAllProvidersUseCase.findAll(pageable, searchTerm);
    }

    @Transactional
    public void deactivateProvider(Long id) {
        deactivateProviderUseCase.deactivate(id);
    }
}