package com.gylgroup.fyc.application.provider.updateProvider.mapper;


import com.gylgroup.fyc.application.provider.updateProvider.dto.UpdateProviderResponse;
import com.gylgroup.fyc.domain.models.Provider;


public class UpdateProviderMapper {


    public static UpdateProviderResponse toResponse(Provider provider) {
        UpdateProviderResponse response = new UpdateProviderResponse();
        response.setId(provider.getId());
        response.setCompanyName(provider.getCompanyName());
        response.setCuit(provider.getCuit());
        response.setEmail(provider.getEmail());
        response.setAddress(provider.getAddress());
        response.setPhone(provider.getPhone());
        response.setEnabled(provider.isEnabled());
        return response;
    }
}
