package com.tarea.infrastructure.security.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequest(
        @NotBlank(message = "Refresh token es requerido")
        String refreshToken
) {
}