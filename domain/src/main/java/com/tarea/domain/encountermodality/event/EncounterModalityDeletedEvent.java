package com.tarea.domain.encountermodality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterModalityDeletedEvent(EncounterModalityId id, LocalDateTime occurredOn) implements DomainEvent {

    public EncounterModalityDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
