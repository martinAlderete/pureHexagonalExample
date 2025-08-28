package com.gylgroup.fyc.infrastructure.repositories;

import com.gylgroup.fyc.infrastructure.entities.ProviderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
    boolean existsByCuit(String cuit);
    boolean existsByEmail(String email);

    @Query("SELECT p FROM ProviderEntity p WHERE " +
            "LOWER(p.businessName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "p.cuit LIKE CONCAT('%', :searchTerm, '%') OR " +
            "LOWER(p.email) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<ProviderEntity> findAllFiltered(Pageable pageable, @Param("searchTerm") String searchTerm);
}