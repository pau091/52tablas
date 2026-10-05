package com.tarea.domain.treatmentstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentStatusDeletedEvent(TreatmentStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public TreatmentStatusDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
