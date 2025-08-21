package com.gylgroup.fyc.infrastructure.repositories;

import com.gylgroup.fyc.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    // Nuevo método para buscar por CUIT en la tabla de proveedores
    @Query("SELECT p FROM ProviderEntity p WHERE p.cuit = :cuit")
    Optional<UserEntity> findByCuit(@Param("cuit") String cuit);
}