package com.tarea.infrastructure.security.adapters.out.persistence.repositories;

import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.mappers.SecurityPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final SecurityPersistenceMapper mapper;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository, SecurityPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        return mapper.userToDomain(jpaRepository.save(mapper.userToEntity(user)));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::userToDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(normalize(email)).map(mapper::userToDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(normalize(email));
    }

    private String normalize(String email) {
        return email == null ? null : email.toLowerCase().trim();
    }
}