package com.tarea.application.chatescalation.dto;

import com.tarea.domain.chatescalation.model.aggregate.ChatEscalation;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatEscalationResponse(
        UUID id,
        UUID conversationId,
        UUID statusId,
        Boolean fromAi,
        String reason,
        LocalDateTime createdAt
) {

    public static ChatEscalationResponse fromDomain(ChatEscalation chatEscalation) {
        return new ChatEscalationResponse(
                chatEscalation.id().value(),
                chatEscalation.conversationId().value(),
                chatEscalation.statusId().value(),
                chatEscalation.fromAi(),
                chatEscalation.reason(),
                chatEscalation.createdAt()
        );
    }
}
