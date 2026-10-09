package com.tarea.domain.security.model;

import com.tarea.domain.security.exception.SecurityDomainException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String password;
    private Set<Role> roles;
    private UserStatus status;

    private User() {
        this.roles = new HashSet<>();
    }

    public static User create(String email, String hashedPassword) {
        if (email == null || email.isBlank()) {
            throw new SecurityDomainException("Email no puede estar vacío");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new SecurityDomainException("Email inválido");
        }
        if (hashedPassword == null || hashedPassword.isBlank()) {
            throw new SecurityDomainException("Password no puede estar vacío");
        }
        User user = new User();
        user.id = UUID.randomUUID();
        user.email = email.toLowerCase().trim();
        user.password = hashedPassword;
        user.status = UserStatus.ACTIVE;
        return user;
    }

    public static User reconstruct(UUID id, String email, String password,
                                   Set<Role> roles, UserStatus status) {
        User user = new User();
        user.id = id;
        user.email = email;
        user.password = password;
        user.roles = new HashSet<>(roles);
        user.status = status;
        return user;
    }

    public void assignRole(Role role) {
        if (role == null) {
            throw new SecurityDomainException("El rol no puede ser nulo");
        }
        this.roles.add(role);
    }

    public void changePassword(String newHashedPassword) {
        if (newHashedPassword == null || newHashedPassword.isBlank()) {
            throw new SecurityDomainException("La nueva contraseña no puede estar vacía");
        }
        this.password = newHashedPassword;
    }

    public void block() {
        this.status = UserStatus.BLOCKED;
    }

    public void activate() {
        this.status = UserStatus.ACTIVE;
    }

    public boolean isActive() {
        return this.status == UserStatus.ACTIVE;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return new HashSet<>(roles);
    }

    public UserStatus getStatus() {
        return status;
    }
}