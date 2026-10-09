package com.tarea.infrastructure.security.adapters.out.persistence.repositories;

import com.tarea.domain.security.model.RefreshToken;
import com.tarea.domain.security.port.repository.RefreshTokenRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.mappers.SecurityPersistenceMapper;

import java.util.Optional;

public class RefreshTokenRepositoryAdapter implements RefreshTokenRepository {

    private final RefreshTokenJpaRepository jpaRepository;
    private final SecurityPersistenceMapper mapper;

    public RefreshTokenRepositoryAdapter(RefreshTokenJpaRepository jpaRepository, SecurityPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return mapper.tokenToDomain(jpaRepository.save(mapper.tokenToEntity(refreshToken)));
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return jpaRepository.findByToken(token).map(mapper::tokenToDomain);
    }
}