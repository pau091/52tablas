package com.tarea.domain.chatconversation.event;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public record ChatConversationUpdatedEvent(
        ChatConversationId id,
        ConversationStatusId conversationStatusId,
        PriorityId priorityId,
        LocalDateTime lastMessageAt,
        Boolean closed,
        LocalDateTime closedAt,
        UUID closedBy,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatConversationUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
