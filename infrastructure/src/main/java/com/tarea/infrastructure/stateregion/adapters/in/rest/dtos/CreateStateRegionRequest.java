package com.tarea.infrastructure.stateregion.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateStateRegionRequest(
        @Size(max = 50) String nameRegion,
        @Size(max = 10) String codeRegion,
        @Size(max = 100) String description,
        Boolean isActive,
        @NotNull UUID countryId
) {
}
