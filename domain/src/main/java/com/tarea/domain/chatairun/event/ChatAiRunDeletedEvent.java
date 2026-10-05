package com.tarea.domain.chatairun.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunDeletedEvent(ChatAiRunId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatAiRunDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
