package com.tarea.domain.escalationstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EscalationStatusDeletedEvent(EscalationStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public EscalationStatusDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
