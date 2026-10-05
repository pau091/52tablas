package com.tarea.infrastructure.clinicalnote.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateClinicalNoteRequest(
        @NotNull UUID encounterId,
        @NotNull UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        LocalDateTime signedAt
) {
}
