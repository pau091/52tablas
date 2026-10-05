package com.tarea.domain.chatescalation.event;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationUpdatedEvent(
        ChatEscalationId id,
        ChatConversationId conversationId,
        EscalationStatusId statusId,
        Boolean fromAi,
        String reason,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
