package com.tarea.domain.chatairunerror.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunErrorDeletedEvent(ChatAiRunErrorId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatAiRunErrorDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
