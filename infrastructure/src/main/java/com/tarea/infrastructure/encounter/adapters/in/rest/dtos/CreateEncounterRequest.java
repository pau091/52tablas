package com.tarea.infrastructure.encounter.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateEncounterRequest(
        @NotNull UUID clinicalRecordId,
        @NotNull UUID professionalId,
        @NotNull UUID encounterTypeId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        @NotNull UUID modalityId,
        @NotNull UUID statusId,
        UUID createdBy,
        UUID updatedBy
) {
}
