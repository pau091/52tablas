package com.tarea.infrastructure.security.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AssignRoleRequest(
        @Schema(description = "USER, ADMIN, MODERATOR o ROLE_*", example = "ADMIN")
        @NotBlank(message = "Nombre del rol es requerido")
        String roleName
) {
}