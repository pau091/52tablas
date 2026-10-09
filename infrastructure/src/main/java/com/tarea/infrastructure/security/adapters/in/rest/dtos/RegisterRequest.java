package com.tarea.infrastructure.security.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Schema(example = "user@tarea.com")
        @NotBlank(message = "Email es requerido")
        @Email(message = "Email debe tener un formato válido")
        String email,

        @Schema(example = "password123")
        @NotBlank(message = "Password es requerido")
        @Size(min = 8, message = "Password debe tener al menos 8 caracteres")
        String password
) {
}