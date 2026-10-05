package com.tarea.domain.treatmentstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentStatusUpdatedEvent(
        TreatmentStatusId id,
        String code,
        String name,
        Boolean active,
        LocalDateTime occurredOn
) implements DomainEvent {

    public TreatmentStatusUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
