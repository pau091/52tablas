package com.tarea.application.security.dto;

import com.tarea.domain.security.model.Role;

import java.util.UUID;

public record RoleResponse(UUID id, String name, String authority) {

    public static RoleResponse fromDomain(Role role) {
        return new RoleResponse(role.getId(), role.getName(), role.getAuthority());
    }
}