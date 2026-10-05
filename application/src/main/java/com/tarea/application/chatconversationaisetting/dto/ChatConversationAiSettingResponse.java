package com.tarea.application.chatconversationaisetting.dto;

import com.tarea.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatConversationAiSettingResponse(
        UUID id,
        UUID conversationId,
        Boolean aiEnabled,
        UUID defaultModelId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ChatConversationAiSettingResponse fromDomain(ChatConversationAiSetting chatConversationAiSetting) {
        return new ChatConversationAiSettingResponse(
                chatConversationAiSetting.id().value(),
                chatConversationAiSetting.conversationId().value(),
                chatConversationAiSetting.aiEnabled(),
                chatConversationAiSetting.defaultModelId().value(),
                chatConversationAiSetting.createdAt(),
                chatConversationAiSetting.updatedAt()
        );
    }
}
