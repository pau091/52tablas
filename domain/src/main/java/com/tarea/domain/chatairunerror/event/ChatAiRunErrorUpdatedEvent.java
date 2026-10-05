package com.tarea.domain.chatairunerror.event;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.tarea.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunErrorUpdatedEvent(
        ChatAiRunErrorId id,
        ChatAiRunId aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunErrorUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
