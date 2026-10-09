package com.tarea.application.security.dto;

import com.tarea.domain.security.model.User;
import com.tarea.domain.security.model.UserStatus;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record UserResponse(UUID id, String email, Set<RoleResponse> roles, UserStatus status) {

    public static UserResponse fromDomain(User user) {
        Set<RoleResponse> roles = user.getRoles().stream()
                .map(RoleResponse::fromDomain)
                .collect(Collectors.toSet());
        return new UserResponse(user.getId(), user.getEmail(), roles, user.getStatus());
    }
}