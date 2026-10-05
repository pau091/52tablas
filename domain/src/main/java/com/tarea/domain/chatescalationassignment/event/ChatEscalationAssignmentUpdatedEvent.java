package com.tarea.domain.chatescalationassignment.event;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationAssignmentUpdatedEvent(
        ChatEscalationAssignmentId id,
        ChatEscalationId escalationId,
        ProfessionalId professionalId,
        LocalDateTime assignedAt,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationAssignmentUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
