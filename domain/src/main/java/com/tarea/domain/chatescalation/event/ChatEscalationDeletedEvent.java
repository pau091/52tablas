package com.tarea.domain.chatescalation.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationDeletedEvent(ChatEscalationId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatEscalationDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
