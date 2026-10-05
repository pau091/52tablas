package com.tarea.application.chatmessage.dto;

import com.tarea.domain.chatmessage.model.aggregate.ChatMessage;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatMessageResponse(
        UUID id,
        UUID conversationId,
        UUID messageTypeId,
        UUID participantId,
        String content,
        String metadata,
        LocalDateTime createdAt
) {

    public static ChatMessageResponse fromDomain(ChatMessage chatMessage) {
        return new ChatMessageResponse(
                chatMessage.id().value(),
                chatMessage.conversationId().value(),
                chatMessage.messageTypeId().value(),
                chatMessage.participantId().value(),
                chatMessage.content(),
                chatMessage.metadata(),
                chatMessage.createdAt()
        );
    }
}
