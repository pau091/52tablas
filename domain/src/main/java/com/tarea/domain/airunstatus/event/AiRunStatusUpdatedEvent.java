package com.tarea.domain.airunstatus.event;

import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public record AiRunStatusUpdatedEvent(
        AiRunStatusId id,
        String nameStatus,
        LocalDateTime occurredOn
) implements DomainEvent {

    public AiRunStatusUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
