package com.tarea.application.chatairunerror.dto;

import com.tarea.domain.chatairunerror.model.aggregate.ChatAiRunError;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatAiRunErrorResponse(
        UUID id,
        UUID aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId,
        LocalDateTime createdAt
) {

    public static ChatAiRunErrorResponse fromDomain(ChatAiRunError chatAiRunError) {
        return new ChatAiRunErrorResponse(
                chatAiRunError.id().value(),
                chatAiRunError.aiRunId().value(),
                chatAiRunError.errorMessage(),
                chatAiRunError.errorCode(),
                chatAiRunError.providerErrorId(),
                chatAiRunError.createdAt()
        );
    }
}
