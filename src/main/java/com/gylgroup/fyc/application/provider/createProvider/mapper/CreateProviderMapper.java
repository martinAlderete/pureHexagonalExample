package com.gylgroup.fyc.application.provider.createProvider.mapper;

import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderRequest;
import com.gylgroup.fyc.application.provider.createProvider.dto.CreateProviderResponse;
import com.gylgroup.fyc.domain.models.Provider;

public class CreateProviderMapper {

    public Provider toDomain(CreateProviderRequest dto) {
        return new Provider(null, null, dto.getEmail(), null, true, null, true, true, true,
                dto.getCuit(), dto.getCompanyName(), dto.getAddress(), dto.getPhone(),
                true, null, null);
    }

    public static CreateProviderResponse toResponse(Provider domain) {
        CreateProviderResponse response = new CreateProviderResponse();
        response.setId(domain.getId());
        response.setCompanyName(domain.getCompanyName());
        response.setCuit(domain.getCuit());
        response.setEmail(domain.getEmail());
        response.setAddress(domain.getAddress());
        response.setPhone(domain.getPhone());
        response.setEnabled(domain.isEnabled());
        response.setCreationDate(domain.getCreationDate());
        return response;
    }
}