package com.tarea.application.security.usecase;

import com.tarea.domain.security.exception.SecurityDomainException;
import com.tarea.domain.security.model.RefreshToken;
import com.tarea.domain.security.port.repository.RefreshTokenRepository;

import java.util.UUID;

public class LogoutUseCase {

    private final RefreshTokenRepository refreshTokenRepository;

    public LogoutUseCase(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public void execute(UUID authenticatedUserId, String refreshTokenValue) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshTokenValue)
                .orElseThrow(() -> new SecurityDomainException("Refresh token no encontrado"));

        // Evita que un usuario cierre la sesión de otro
        if (!token.belongsTo(authenticatedUserId)) {
            throw new SecurityDomainException("El refresh token no pertenece al usuario autenticado");
        }

        token.revoke();
        refreshTokenRepository.save(token);
    }
}