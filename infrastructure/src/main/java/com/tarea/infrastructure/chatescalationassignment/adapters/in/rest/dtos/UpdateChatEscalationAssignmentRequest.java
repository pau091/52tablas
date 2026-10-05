package com.tarea.infrastructure.chatescalationassignment.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatEscalationAssignmentRequest(
        @NotNull UUID escalationId,
        @NotNull UUID professionalId,
        LocalDateTime assignedAt
) {
}
