package com.tarea.domain.treatmentplan.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentPlanRegisteredEvent(TreatmentPlanId id, LocalDateTime occurredOn) implements DomainEvent {

    public TreatmentPlanRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
