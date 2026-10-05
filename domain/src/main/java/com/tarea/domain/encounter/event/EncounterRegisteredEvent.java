package com.tarea.domain.encounter.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterRegisteredEvent(EncounterId id, LocalDateTime occurredOn) implements DomainEvent {

    public EncounterRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
