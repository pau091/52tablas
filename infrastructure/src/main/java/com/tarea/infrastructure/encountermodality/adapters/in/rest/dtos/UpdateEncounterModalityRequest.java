package com.tarea.infrastructure.encountermodality.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateEncounterModalityRequest(
        @NotBlank @Size(max = 20) String code,
        @Size(max = 50) String name,
        Boolean active
) {
}
