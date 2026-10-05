package com.tarea.domain.encountertype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterTypeUpdatedEvent(
        EncounterTypeId id,
        String code,
        String name,
        Boolean active,
        LocalDateTime occurredOn
) implements DomainEvent {

    public EncounterTypeUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
