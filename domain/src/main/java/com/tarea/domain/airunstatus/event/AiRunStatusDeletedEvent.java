package com.tarea.domain.airunstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record AiRunStatusDeletedEvent(AiRunStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public AiRunStatusDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
