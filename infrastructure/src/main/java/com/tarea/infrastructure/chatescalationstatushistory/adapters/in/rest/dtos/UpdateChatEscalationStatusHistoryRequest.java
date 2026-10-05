package com.tarea.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatEscalationStatusHistoryRequest(
        @NotNull UUID escalationId,
        @NotNull UUID escalationStatusId,
        LocalDateTime changedAt
) {
}
