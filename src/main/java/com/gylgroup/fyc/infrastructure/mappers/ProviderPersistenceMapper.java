package com.gylgroup.fyc.infrastructure.mappers;

import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.infrastructure.entities.ProviderEntity;
import org.springframework.stereotype.Component;

@Component
public class ProviderPersistenceMapper {

    public Provider toDomain(ProviderEntity entity) {
        return new Provider(
                entity.getId(), entity.getPassword(), entity.getEmail(), null,
                entity.isEnabled(), entity.getCreationDate(), entity.isAccountNonExpired(),
                entity.isAccountNonLocked(), entity.isCredentialsNonExpired(), entity.getCuit(),
                entity.getBusinessName(), entity.getAddress(), entity.getPhone(),
                true, null, null);
    }

    public ProviderEntity toEntity(Provider domain) {
        ProviderEntity entity = new ProviderEntity();
        entity.setId(domain.getId());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setCuit(domain.getCuit());
        entity.setBusinessName(domain.getCompanyName());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEnabled(domain.isEnabled());
        entity.setCreationDate(domain.getCreationDate());
        return entity;
    }
}