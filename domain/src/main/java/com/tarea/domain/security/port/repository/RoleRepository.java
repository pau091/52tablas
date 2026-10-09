package com.tarea.domain.security.port.repository;

import com.tarea.domain.security.model.Role;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(String name);

    Optional<Role> findByAuthority(String authority);
}