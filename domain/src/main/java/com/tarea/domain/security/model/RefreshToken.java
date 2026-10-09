package com.tarea.domain.security.model;

import com.tarea.domain.security.exception.SecurityDomainException;

import java.time.LocalDateTime;
import java.util.UUID;

public class RefreshToken {

    private UUID id;
    private UUID userId;
    private String token;
    private LocalDateTime expiresAt;
    private boolean revoked;

    private RefreshToken() {
    }

    public static RefreshToken create(UUID userId, String token, LocalDateTime expiresAt) {
        if (userId == null) {
            throw new SecurityDomainException("UserId no puede ser nulo");
        }
        if (token == null || token.isBlank()) {
            throw new SecurityDomainException("Token no puede estar vacío");
        }
        if (expiresAt == null) {
            throw new SecurityDomainException("Fecha de expiración no puede ser nula");
        }
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.id = UUID.randomUUID();
        refreshToken.userId = userId;
        refreshToken.token = token;
        refreshToken.expiresAt = expiresAt;
        refreshToken.revoked = false;
        return refreshToken;
    }

    public static RefreshToken reconstruct(UUID id, UUID userId, String token,
                                           LocalDateTime expiresAt, boolean revoked) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.id = id;
        refreshToken.userId = userId;
        refreshToken.token = token;
        refreshToken.expiresAt = expiresAt;
        refreshToken.revoked = revoked;
        return refreshToken;
    }

    public void revoke() {
        this.revoked = true;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public boolean isValid() {
        return !revoked && !isExpired();
    }

    public boolean belongsTo(UUID otherUserId) {
        return userId.equals(otherUserId);
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public boolean isRevoked() {
        return revoked;
    }
}