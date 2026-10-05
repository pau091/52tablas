package com.tarea.domain.chatmessage.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatMessageDeletedEvent(ChatMessageId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatMessageDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
