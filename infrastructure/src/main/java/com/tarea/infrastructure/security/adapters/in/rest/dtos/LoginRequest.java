package com.tarea.infrastructure.security.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Schema(example = "admin@tarea.com")
        @NotBlank(message = "Email es requerido")
        @Email(message = "Email debe tener un formato válido")
        String email,

        @Schema(example = "Admin123*")
        @NotBlank(message = "Password es requerido")
        String password
) {
}