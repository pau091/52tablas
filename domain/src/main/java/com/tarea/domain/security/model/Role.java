package com.tarea.domain.security.model;

import com.tarea.domain.security.exception.SecurityDomainException;

import java.util.UUID;

public class Role {

    private UUID id;
    private String name;
    private String authority;

    private Role() {
    }

    public static Role create(String name, String authority) {
        if (name == null || name.isBlank()) {
            throw new SecurityDomainException("El nombre del rol no puede estar vacío");
        }
        if (authority == null || authority.isBlank()) {
            throw new SecurityDomainException("El authority del rol no puede estar vacío");
        }
        Role role = new Role();
        role.id = UUID.randomUUID();
        role.name = name.toUpperCase().trim();
        role.authority = authority.toUpperCase().trim();
        return role;
    }

    public static Role reconstruct(UUID id, String name, String authority) {
        Role role = new Role();
        role.id = id;
        role.name = name;
        role.authority = authority;
        return role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id != null && id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}