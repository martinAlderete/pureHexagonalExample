package com.gylgroup.fyc.application.provider.updateProvider.usecase;

import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderRequest;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;

import com.gylgroup.fyc.application.provider.updateProvider.mapper.UpdateProviderMapper;
import com.gylgroup.fyc.application.provider.updateProvider.usecase.port.in.UpdateProvider;
import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.ports.out.ProviderModelPort;

public class UpdateProviderImpl implements UpdateProvider {

    private final ProviderModelPort providerModelPort;

    public UpdateProviderImpl(ProviderModelPort providerModelPort) {
        this.providerModelPort = providerModelPort;
    }

    @Override
    public UpdateProviderResponse update(Long id, UpdateProviderRequest request) {
        Provider providerFounded = providerModelPort.findById(id).
                orElseThrow(() -> new RuntimeException("Proveedor con ID " + id + " no encontrado."));

        if (!providerFounded.getEmail().equals(request.getEmail()) && providerModelPort.existsByEmail(request.getEmail())) {
            throw new IllegalStateException("El email " + request.getEmail() + " ya está en uso por otro proveedor.");
        }


        providerFounded.setAddress(request.getAddress());
        providerFounded.setCompanyName(request.getCompanyName());
        providerFounded.setEmail(request.getEmail());
        providerFounded.setPhone(request.getPhone());


      Provider updatedProvider = providerModelPort.save(providerFounded);

        return UpdateProviderMapper.toResponse(updatedProvider);

    }
}
