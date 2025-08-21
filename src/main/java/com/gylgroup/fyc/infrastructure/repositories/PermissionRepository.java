package com.gylgroup.fyc.infrastructure.repositories;

import com.gylgroup.fyc.infrastructure.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
}