package com.tarea.domain.chatairun.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunRegisteredEvent(ChatAiRunId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatAiRunRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
