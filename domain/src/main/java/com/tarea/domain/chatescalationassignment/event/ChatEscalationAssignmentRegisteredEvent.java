package com.tarea.domain.chatescalationassignment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationAssignmentRegisteredEvent(ChatEscalationAssignmentId id, LocalDateTime occurredOn) implements DomainEvent {

    public ChatEscalationAssignmentRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
