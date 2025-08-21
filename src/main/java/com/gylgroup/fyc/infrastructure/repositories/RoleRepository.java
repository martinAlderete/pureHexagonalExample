package com.gylgroup.fyc.infrastructure.repositories;

import com.gylgroup.fyc.infrastructure.entities.RoleEntity;
import com.gylgroup.fyc.infrastructure.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleName name);
}