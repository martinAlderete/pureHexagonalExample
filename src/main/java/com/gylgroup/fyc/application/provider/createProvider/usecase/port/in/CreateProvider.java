package com.gylgroup.fyc.application.provider.createProvider.usecase.port.in;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.domain.models.Provider;

public interface CreateProvider {

    CreateProviderResponse createProvider(CreateProviderRequest request);
}
