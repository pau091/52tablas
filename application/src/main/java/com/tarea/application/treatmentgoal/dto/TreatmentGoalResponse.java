package com.tarea.application.treatmentgoal.dto;

import com.tarea.domain.treatmentgoal.model.aggregate.TreatmentGoal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TreatmentGoalResponse(
        UUID id,
        UUID treatmentPlanId,
        String description,
        LocalDate targetDate,
        LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TreatmentGoalResponse fromDomain(TreatmentGoal treatmentGoal) {
        return new TreatmentGoalResponse(
                treatmentGoal.id().value(),
                treatmentGoal.treatmentPlanId().value(),
                treatmentGoal.description(),
                treatmentGoal.targetDate(),
                treatmentGoal.completedAt(),
                treatmentGoal.notes(),
                treatmentGoal.treatmentGoalId().value(),
                treatmentGoal.createdAt(),
                treatmentGoal.updatedAt()
        );
    }
}
