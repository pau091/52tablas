package com.tarea.infrastructure.professional.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateProfessionalRequest(
        @NotNull UUID documentTypeId,
        @NotBlank @Size(max = 30) String documentNumber,
        @Size(max = 60) String firstName,
        @Size(max = 60) String lastName,
        @NotNull UUID professionalType,
        @NotBlank @Size(max = 100) String licenseNumber,
        Boolean active,
        @NotNull UUID cityId
) {
}
