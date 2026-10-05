package com.tarea.application.treatmentgoalstatus.dto;

import com.tarea.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TreatmentGoalStatusResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TreatmentGoalStatusResponse fromDomain(TreatmentGoalStatus treatmentGoalStatus) {
        return new TreatmentGoalStatusResponse(
                treatmentGoalStatus.id().value(),
                treatmentGoalStatus.code(),
                treatmentGoalStatus.name(),
                treatmentGoalStatus.active(),
                treatmentGoalStatus.createdAt(),
                treatmentGoalStatus.updatedAt()
        );
    }
}
