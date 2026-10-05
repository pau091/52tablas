package com.tarea.application.chatescalationassignment.dto;

import com.tarea.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatEscalationAssignmentResponse(
        UUID id,
        UUID escalationId,
        UUID professionalId,
        LocalDateTime assignedAt
) {

    public static ChatEscalationAssignmentResponse fromDomain(ChatEscalationAssignment chatEscalationAssignment) {
        return new ChatEscalationAssignmentResponse(
                chatEscalationAssignment.id().value(),
                chatEscalationAssignment.escalationId().value(),
                chatEscalationAssignment.professionalId().value(),
                chatEscalationAssignment.assignedAt()
        );
    }
}
