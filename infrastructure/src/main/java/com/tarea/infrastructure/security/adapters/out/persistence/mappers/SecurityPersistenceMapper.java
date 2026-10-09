package com.tarea.infrastructure.security.adapters.out.persistence.mappers;

import com.tarea.domain.security.model.RefreshToken;
import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.model.User;
import com.tarea.infrastructure.security.adapters.out.persistence.entity.RefreshTokenJpaEntity;
import com.tarea.infrastructure.security.adapters.out.persistence.entity.RoleJpaEntity;
import com.tarea.infrastructure.security.adapters.out.persistence.entity.UserJpaEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class SecurityPersistenceMapper {

    public RoleJpaEntity roleToEntity(Role role) {
        return new RoleJpaEntity(role.getId(), role.getName(), role.getAuthority());
    }

    public Role roleToDomain(RoleJpaEntity entity) {
        return Role.reconstruct(entity.getId(), entity.getName(), entity.getAuthority());
    }

    public UserJpaEntity userToEntity(User user) {
        Set<RoleJpaEntity> roles = user.getRoles().stream()
                .map(this::roleToEntity)
                .collect(Collectors.toSet());
        return new UserJpaEntity(user.getId(), user.getEmail(), user.getPassword(), roles, user.getStatus());
    }

    public User userToDomain(UserJpaEntity entity) {
        Set<Role> roles = entity.getRoles().stream()
                .map(this::roleToDomain)
                .collect(Collectors.toSet());
        return User.reconstruct(entity.getId(), entity.getEmail(), entity.getPassword(), roles, entity.getStatus());
    }

    public RefreshTokenJpaEntity tokenToEntity(RefreshToken token) {
        return new RefreshTokenJpaEntity(token.getId(), token.getUserId(), token.getToken(),
                token.getExpiresAt(), token.isRevoked());
    }

    public RefreshToken tokenToDomain(RefreshTokenJpaEntity entity) {
        return RefreshToken.reconstruct(entity.getId(), entity.getUserId(), entity.getToken(),
                entity.getExpiresAt(), entity.isRevoked());
    }
}