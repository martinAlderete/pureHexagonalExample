package com.gylgroup.fyc.application.provider.getAllProviders.mapper;

import com.gylgroup.fyc.application.provider.getAllProviders.dto.ProviderSummaryResponse;
import com.gylgroup.fyc.domain.models.Provider;

public class GetAllProvidersMapper {
    public ProviderSummaryResponse toResponse(Provider domain) {
        ProviderSummaryResponse res = new ProviderSummaryResponse();
        res.setId(domain.getId());
        res.setCompanyName(domain.getCompanyName());
        res.setCuit(domain.getCuit());
        res.setEmail(domain.getEmail());
        res.setPhone(domain.getPhone());
        res.setEnabled(domain.isEnabled());
        return res;
    }
}