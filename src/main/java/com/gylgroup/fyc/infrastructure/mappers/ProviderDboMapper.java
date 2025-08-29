package com.gylgroup.fyc.infrastructure.mappers;

import com.gylgroup.fyc.domain.models.Provider;
import com.gylgroup.fyc.domain.models.Role;
import com.gylgroup.fyc.infrastructure.entities.ProviderEntity;
import org.springframework.stereotype.Component;
import java.util.Set;


@Component
public class ProviderDboMapper {

    private final RoleDboMapper roleDboMapper;

    public ProviderDboMapper(RoleDboMapper roleDboMapper) {
        this.roleDboMapper = roleDboMapper;
    }

    public Provider toDomain(ProviderEntity entity) {
        Set<Role> roles = entity.getRole() != null
                ? Set.of(roleDboMapper.toDomain(entity.getRole()))
                : Set.of();

        return new Provider(
                entity.getId(),
                entity.getPassword(),
                entity.getEmail(),
                roles,
                entity.isEnabled(),
                entity.getCreationDate(),
                entity.isAccountNonExpired(),
                entity.isAccountNonLocked(),
                entity.isCredentialsNonExpired(),
                entity.getCuit(),
                entity.getBusinessName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.isFirstLogin(),
                null, // employees se manejarán en otro caso de uso
                null  // city se manejará en otro caso de uso
        );
    }

    public ProviderEntity toEntity(Provider domain) {
        ProviderEntity entity = new ProviderEntity();

        entity.setId(domain.getId());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setEnabled(domain.isEnabled());
        entity.setCreationDate(domain.getCreationDate());

        entity.setCuit(domain.getCuit());
        entity.setBusinessName(domain.getCompanyName());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setFirstLogin(domain.isFirstLogin());

        if (domain.getRoles() != null && !domain.getRoles().isEmpty()) {
            Role domainRole = domain.getRoles().iterator().next();
            entity.setRole(roleDboMapper.toEntity(domainRole));
        }

        return entity;
    }
}