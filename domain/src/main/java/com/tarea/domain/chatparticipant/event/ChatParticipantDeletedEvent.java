package com.tarea.domain.chatparticipant.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatParticipantDeletedEvent(ChatParticipantId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatParticipantDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
