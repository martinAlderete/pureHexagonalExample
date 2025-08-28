package com.gylgroup.fyc.application.provider.getAllProviders.usecase;

import com.gylgroup.fyc.application.provider.getAllProviders.usecase.port.in.GetAllProviders;
import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GetAllProvidersImpl implements GetAllProviders {
    private final ProviderModelPort providerModelPort;

    public GetAllProvidersImpl(ProviderModelPort providerModelPort) {
        this.providerModelPort = providerModelPort;
    }

    @Override
    public Page<Provider> findAll(Pageable pageable, String searchTerm) {
        return providerModelPort.findAll(pageable, searchTerm);
    }
}