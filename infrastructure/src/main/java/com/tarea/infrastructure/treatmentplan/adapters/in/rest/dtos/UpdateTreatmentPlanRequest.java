package com.tarea.infrastructure.treatmentplan.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateTreatmentPlanRequest(
        @NotNull UUID encounterId,
        @NotNull UUID professionalId,
        @Size(max = 200) String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        @NotNull UUID treatmentStatusId
) {
}
