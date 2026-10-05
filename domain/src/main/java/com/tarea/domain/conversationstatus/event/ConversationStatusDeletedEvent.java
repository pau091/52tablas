package com.tarea.domain.conversationstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ConversationStatusDeletedEvent(ConversationStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public ConversationStatusDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
