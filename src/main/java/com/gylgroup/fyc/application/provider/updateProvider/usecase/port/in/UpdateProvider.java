package com.gylgroup.fyc.application.provider.updateProvider.usecase.port.in;

import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderRequest;
import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;
import com.gylgroup.fyc.domain.models.Provider;

public interface UpdateProvider {

    UpdateProviderResponse update(Long id, UpdateProviderRequest request);
}
