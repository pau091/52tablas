package com.tarea.infrastructure.clinicalrecord.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateClinicalRecordRequest(
        @NotNull UUID patientId,
        LocalDateTime creationDate,
        @Size(max = 50) String recordNumber,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        @NotNull UUID statusId,
        @NotNull UUID createdBy
) {
}
