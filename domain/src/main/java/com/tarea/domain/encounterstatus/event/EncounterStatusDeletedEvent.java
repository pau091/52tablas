package com.tarea.domain.encounterstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterStatusDeletedEvent(EncounterStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public EncounterStatusDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
