package com.tarea.application.chatairunmetric.dto;

import com.tarea.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ChatAiRunMetricResponse(
        UUID id,
        UUID aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        BigDecimal cost,
        LocalDateTime createdAt
) {

    public static ChatAiRunMetricResponse fromDomain(ChatAiRunMetric chatAiRunMetric) {
        return new ChatAiRunMetricResponse(
                chatAiRunMetric.id().value(),
                chatAiRunMetric.aiRunId().value(),
                chatAiRunMetric.promptTokens(),
                chatAiRunMetric.completionTokens(),
                chatAiRunMetric.totalTokens(),
                chatAiRunMetric.cost(),
                chatAiRunMetric.createdAt()
        );
    }
}
