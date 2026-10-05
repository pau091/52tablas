package com.tarea.infrastructure.chatescalation.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateChatEscalationRequest(
        @NotNull UUID conversationId,
        @NotNull UUID statusId,
        Boolean fromAi,
        String reason
) {
}
