package com.tarea.domain.treatmentgoal.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentGoalDeletedEvent(TreatmentGoalId id, LocalDateTime occurredOn) implements DomainEvent {

    public TreatmentGoalDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
