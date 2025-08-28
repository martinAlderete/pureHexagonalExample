package com.gylgroup.fyc.application.provider.createProvider.usecase;

import com.gylgroup.fyc.application.provider.createProvider.usecase.port.in.CreateProvider;
import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;

public class CreateProviderImpl implements CreateProvider {

    private final ProviderModelPort providerModelPort;

    public CreateProviderImpl(ProviderModelPort providerModelPort) {
        this.providerModelPort = providerModelPort;
    }

    @Override
    public Provider createProvider(Provider provider) {
        if (providerModelPort.existsByCuit(provider.getCuit())) {
            throw new IllegalStateException("El CUIT '" + provider.getCuit() + "' ya se encuentra registrado.");
        }
        if (providerModelPort.existsByEmail(provider.getEmail())) {
            throw new IllegalStateException("El Email '" + provider.getEmail() + "' ya se encuentra registrado.");
        }
        return providerModelPort.save(provider);
    }
}