package com.tarea.infrastructure.chatairunerror.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateChatAiRunErrorRequest(
        @NotNull UUID aiRunId,
        String errorMessage,
        @Size(max = 80) String errorCode,
        @Size(max = 120) String providerErrorId
) {
}
