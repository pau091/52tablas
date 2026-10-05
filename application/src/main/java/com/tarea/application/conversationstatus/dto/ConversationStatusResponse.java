package com.tarea.application.conversationstatus.dto;

import com.tarea.domain.conversationstatus.model.aggregate.ConversationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConversationStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ConversationStatusResponse fromDomain(ConversationStatus conversationStatus) {
        return new ConversationStatusResponse(
                conversationStatus.id().value(),
                conversationStatus.nameStatus(),
                conversationStatus.createdAt(),
                conversationStatus.updatedAt()
        );
    }
}
