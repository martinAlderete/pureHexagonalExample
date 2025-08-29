package com.gylgroup.fyc.infrastructure.mappers;

import com.gylgroup.fyc.domain.models.Role;
import com.gylgroup.fyc.infrastructure.entities.RoleEntity;
import org.springframework.stereotype.Component;


@Component
public class RoleDboMapper {

    public Role toDomain(RoleEntity entity) {
        if (entity == null) return null;
        return new Role(entity.getId(), entity.getName().name());
    }

    public RoleEntity toEntity(Role domain) {
        if (domain == null) return null;
        RoleEntity entity = new RoleEntity();
        entity.setId(domain.getId());

        return entity;
    }
}