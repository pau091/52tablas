package com.tarea.infrastructure.patientallergy.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdatePatientAllergyRequest(
        @NotNull UUID patientId,
        @Size(max = 200) String substance,
        String reaction,
        @Size(max = 20) String severity,
        Boolean active,
        LocalDateTime recordedAt,
        UUID recordedBy
) {
}
