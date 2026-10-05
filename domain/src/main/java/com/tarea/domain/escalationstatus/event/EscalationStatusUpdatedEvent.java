package com.tarea.domain.escalationstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EscalationStatusUpdatedEvent(
        EscalationStatusId id,
        String nameStatus,
        LocalDateTime occurredOn
) implements DomainEvent {

    public EscalationStatusUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
