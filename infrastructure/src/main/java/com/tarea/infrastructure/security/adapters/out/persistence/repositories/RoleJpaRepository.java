package com.tarea.infrastructure.security.adapters.out.persistence.repositories;

import com.tarea.infrastructure.security.adapters.out.persistence.entity.RoleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, UUID> {

    Optional<RoleJpaEntity> findByName(String name);

    Optional<RoleJpaEntity> findByAuthority(String authority);
}