package com.tarea.application.chatconversation.command;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatConversationCommand(
        ChatConversationId id,
        ConversationStatusId conversationStatusId,
        PriorityId priorityId,
        LocalDateTime lastMessageAt,
        Boolean closed,
        LocalDateTime closedAt,
        UUID closedBy
) {
}
