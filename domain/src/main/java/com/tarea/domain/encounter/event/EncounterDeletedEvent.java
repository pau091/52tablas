package com.tarea.domain.encounter.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterDeletedEvent(EncounterId id, LocalDateTime occurredOn) implements DomainEvent {

    public EncounterDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
