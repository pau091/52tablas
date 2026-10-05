package com.tarea.infrastructure.citymunicipality.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateCityMunicipalityRequest(
        @Size(max = 50) String nameCity,
        @Size(max = 10) String codeCity,
        @Size(max = 100) String description,
        Boolean isActive,
        @NotNull UUID regionId
) {
}
