package com.tarea.application.chatconversation.command;

import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterChatConversationCommand(
        ConversationStatusId conversationStatusId,
        PriorityId priorityId,
        LocalDateTime lastMessageAt,
        Boolean closed,
        LocalDateTime closedAt,
        UUID closedBy
) {
}
