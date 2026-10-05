package com.tarea.domain.chatairunmetric.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunMetricRegisteredEvent(ChatAiRunMetricId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatAiRunMetricRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
