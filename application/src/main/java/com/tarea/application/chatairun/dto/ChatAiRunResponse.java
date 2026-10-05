package com.tarea.application.chatairun.dto;

import com.tarea.domain.chatairun.model.aggregate.ChatAiRun;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatAiRunResponse(
        UUID id,
        UUID conversationId,
        UUID messageId,
        UUID modelId,
        UUID aiRunStatusId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ChatAiRunResponse fromDomain(ChatAiRun chatAiRun) {
        return new ChatAiRunResponse(
                chatAiRun.id().value(),
                chatAiRun.conversationId().value(),
                chatAiRun.messageId().value(),
                chatAiRun.modelId().value(),
                chatAiRun.aiRunStatusId().value(),
                chatAiRun.createdAt(),
                chatAiRun.updatedAt()
        );
    }
}
