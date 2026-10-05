package com.tarea.application.treatmentplan.dto;

import com.tarea.domain.treatmentplan.model.aggregate.TreatmentPlan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TreatmentPlanResponse(
        UUID id,
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        UUID treatmentStatusId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TreatmentPlanResponse fromDomain(TreatmentPlan treatmentPlan) {
        return new TreatmentPlanResponse(
                treatmentPlan.id().value(),
                treatmentPlan.encounterId().value(),
                treatmentPlan.professionalId().value(),
                treatmentPlan.title(),
                treatmentPlan.description(),
                treatmentPlan.startDate(),
                treatmentPlan.endDate(),
                treatmentPlan.treatmentStatusId().value(),
                treatmentPlan.createdAt(),
                treatmentPlan.updatedAt()
        );
    }
}
