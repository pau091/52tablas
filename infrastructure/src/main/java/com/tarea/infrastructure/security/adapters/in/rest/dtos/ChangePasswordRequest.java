package com.tarea.infrastructure.security.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank(message = "Password actual es requerido")
        String currentPassword,

        @NotBlank(message = "Nueva password es requerida")
        @Size(min = 8, message = "Nueva password debe tener al menos 8 caracteres")
        String newPassword
) {
}