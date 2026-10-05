package com.tarea.domain.chatairunmetric.event;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.tarea.domain.common.event.DomainEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunMetricUpdatedEvent(
        ChatAiRunMetricId id,
        ChatAiRunId aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        BigDecimal cost,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunMetricUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
