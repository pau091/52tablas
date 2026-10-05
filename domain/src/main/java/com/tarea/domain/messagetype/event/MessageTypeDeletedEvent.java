package com.tarea.domain.messagetype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MessageTypeDeletedEvent(MessageTypeId id, LocalDateTime occurredOn) implements DomainEvent {

    public MessageTypeDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
