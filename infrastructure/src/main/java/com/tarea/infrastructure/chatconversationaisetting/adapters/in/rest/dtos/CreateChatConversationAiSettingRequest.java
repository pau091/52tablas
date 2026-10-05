package com.tarea.infrastructure.chatconversationaisetting.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateChatConversationAiSettingRequest(
        @NotNull UUID conversationId,
        Boolean aiEnabled,
        @NotNull UUID defaultModelId
) {
}
