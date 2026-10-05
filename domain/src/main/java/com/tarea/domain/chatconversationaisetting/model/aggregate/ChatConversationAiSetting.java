package com.tarea.domain.chatconversationaisetting.model.aggregate;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingDeletedEvent;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingRegisteredEvent;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingUpdatedEvent;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatConversationAiSetting extends AggregateRoot {

    private final ChatConversationAiSettingId id;
    private ChatConversationId conversationId;
    private Boolean aiEnabled;
    private AiModelId defaultModelId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatConversationAiSetting(
            ChatConversationAiSettingId id,
            ChatConversationId conversationId,
            Boolean aiEnabled,
            AiModelId defaultModelId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.aiEnabled = aiEnabled;
        this.defaultModelId = Objects.requireNonNull(defaultModelId, "defaultModelId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ChatConversationAiSetting register(ChatConversationId conversationId, Boolean aiEnabled, AiModelId defaultModelId) {
        ChatConversationAiSettingId id = ChatConversationAiSettingId.generate();
        ChatConversationAiSetting chatConversationAiSetting = new ChatConversationAiSetting(
                id,
                conversationId,
                aiEnabled != null ? aiEnabled : Boolean.TRUE,
                defaultModelId,
                LocalDateTime.now(),
                null);
        chatConversationAiSetting.recordEvent(new ChatConversationAiSettingRegisteredEvent(id, LocalDateTime.now()));
        return chatConversationAiSetting;
    }

    public static ChatConversationAiSetting restore(
            ChatConversationAiSettingId id,
            ChatConversationId conversationId,
            Boolean aiEnabled,
            AiModelId defaultModelId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ChatConversationAiSetting(
                id,
                conversationId,
                aiEnabled,
                defaultModelId,
                createdAt,
                updatedAt);
    }

    public void update(ChatConversationId conversationId, Boolean aiEnabled, AiModelId defaultModelId) {
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.aiEnabled = aiEnabled;
        this.defaultModelId = Objects.requireNonNull(defaultModelId, "defaultModelId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatConversationAiSettingUpdatedEvent(
                id,
                this.conversationId,
                this.aiEnabled,
                this.defaultModelId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatConversationAiSettingDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatConversationAiSettingId id() {
        return id;
    }

    public ChatConversationId conversationId() {
        return conversationId;
    }

    public Boolean aiEnabled() {
        return aiEnabled;
    }

    public AiModelId defaultModelId() {
        return defaultModelId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
