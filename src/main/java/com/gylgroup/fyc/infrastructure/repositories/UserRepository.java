package com.gylgroup.fyc.infrastructure.repositories;


import com.gylgroup.fyc.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
