package com.tarea.domain.chatconversationaisetting.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationAiSettingRegisteredEvent(ChatConversationAiSettingId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatConversationAiSettingRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
