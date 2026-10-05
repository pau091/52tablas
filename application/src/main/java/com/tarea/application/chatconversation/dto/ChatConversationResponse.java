package com.tarea.application.chatconversation.dto;

import com.tarea.domain.chatconversation.model.aggregate.ChatConversation;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatConversationResponse(
        UUID id,
        UUID conversationStatusId,
        UUID priorityId,
        LocalDateTime lastMessageAt,
        Boolean closed,
        LocalDateTime closedAt,
        UUID closedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ChatConversationResponse fromDomain(ChatConversation chatConversation) {
        return new ChatConversationResponse(
                chatConversation.id().value(),
                chatConversation.conversationStatusId().value(),
                chatConversation.priorityId().value(),
                chatConversation.lastMessageAt(),
                chatConversation.closed(),
                chatConversation.closedAt(),
                chatConversation.closedBy(),
                chatConversation.createdAt(),
                chatConversation.updatedAt()
        );
    }
}
