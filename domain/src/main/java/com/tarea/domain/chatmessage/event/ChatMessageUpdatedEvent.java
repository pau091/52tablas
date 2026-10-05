package com.tarea.domain.chatmessage.event;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatMessageUpdatedEvent(
        ChatMessageId id,
        ChatConversationId conversationId,
        MessageTypeId messageTypeId,
        ChatParticipantId participantId,
        String content,
        String metadata,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatMessageUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
