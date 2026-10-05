package com.tarea.domain.chatescalationstatushistory.event;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationStatusHistoryUpdatedEvent(
        ChatEscalationStatusHistoryId id,
        ChatEscalationId escalationId,
        EscalationStatusId escalationStatusId,
        LocalDateTime changedAt,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationStatusHistoryUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
