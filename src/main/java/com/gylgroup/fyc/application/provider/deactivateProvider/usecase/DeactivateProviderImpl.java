package com.gylgroup.fyc.application.provider.deactivateProvider.usecase;

import com.gylgroup.fyc.application.provider.deactivateProvider.usecase.port.in.DeactivateProvider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;

public class DeactivateProviderImpl implements DeactivateProvider {

    private final ProviderModelPort providerModelPort;

    public DeactivateProviderImpl(ProviderModelPort providerModelPort) {
        this.providerModelPort = providerModelPort;
    }

    @Override
    public boolean deactivate(Long id) {
        return providerModelPort.findById(id).map(provider -> {
            provider.setEnabled(false); // Baja lógica
            providerModelPort.save(provider);
            return true;
        }).orElse(false);
    }
}