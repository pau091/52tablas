package com.tarea.domain.treatmentgoal.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentGoalUpdatedEvent(
        TreatmentGoalId id,
        TreatmentPlanId treatmentPlanId,
        String description,
        LocalDate targetDate,
        LocalDateTime completedAt,
        String notes,
        TreatmentGoalStatusId treatmentGoalId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public TreatmentGoalUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
