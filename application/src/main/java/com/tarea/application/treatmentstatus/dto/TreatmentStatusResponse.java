package com.tarea.application.treatmentstatus.dto;

import com.tarea.domain.treatmentstatus.model.aggregate.TreatmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TreatmentStatusResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TreatmentStatusResponse fromDomain(TreatmentStatus treatmentStatus) {
        return new TreatmentStatusResponse(
                treatmentStatus.id().value(),
                treatmentStatus.code(),
                treatmentStatus.name(),
                treatmentStatus.active(),
                treatmentStatus.createdAt(),
                treatmentStatus.updatedAt()
        );
    }
}
