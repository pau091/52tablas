package com.tarea.domain.encounterstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterStatusUpdatedEvent(
        EncounterStatusId id,
        String code,
        String name,
        Boolean active,
        LocalDateTime occurredOn
) implements DomainEvent {

    public EncounterStatusUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
