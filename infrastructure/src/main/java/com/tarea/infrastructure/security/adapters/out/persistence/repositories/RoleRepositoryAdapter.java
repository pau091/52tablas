package com.tarea.infrastructure.security.adapters.out.persistence.repositories;

import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.port.repository.RoleRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.mappers.SecurityPersistenceMapper;

import java.util.Optional;

public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository jpaRepository;
    private final SecurityPersistenceMapper mapper;

    public RoleRepositoryAdapter(RoleJpaRepository jpaRepository, SecurityPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return jpaRepository.findByName(name).map(mapper::roleToDomain);
    }

    @Override
    public Optional<Role> findByAuthority(String authority) {
        return jpaRepository.findByAuthority(authority).map(mapper::roleToDomain);
    }
}