package com.tarea.domain.chatconversationaisetting.event;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationAiSettingUpdatedEvent(
        ChatConversationAiSettingId id,
        ChatConversationId conversationId,
        Boolean aiEnabled,
        AiModelId defaultModelId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatConversationAiSettingUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
