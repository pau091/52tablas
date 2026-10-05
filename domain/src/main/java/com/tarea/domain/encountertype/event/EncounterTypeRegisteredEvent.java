package com.tarea.domain.encountertype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterTypeRegisteredEvent(EncounterTypeId id, LocalDateTime occurredOn) implements DomainEvent {

    public EncounterTypeRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
