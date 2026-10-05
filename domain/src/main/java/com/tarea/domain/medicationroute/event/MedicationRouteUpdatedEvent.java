package com.tarea.domain.medicationroute.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MedicationRouteUpdatedEvent(
        MedicationRouteId id,
        String code,
        String name,
        Boolean active,
        LocalDateTime occurredOn
) implements DomainEvent {

    public MedicationRouteUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
