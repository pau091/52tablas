package com.tarea.domain.chatairun.model.aggregate;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.chatairun.event.ChatAiRunDeletedEvent;
import com.tarea.domain.chatairun.event.ChatAiRunRegisteredEvent;
import com.tarea.domain.chatairun.event.ChatAiRunUpdatedEvent;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatAiRun extends AggregateRoot {

    private final ChatAiRunId id;
    private ChatConversationId conversationId;
    private ChatMessageId messageId;
    private AiModelId modelId;
    private AiRunStatusId aiRunStatusId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatAiRun(
            ChatAiRunId id,
            ChatConversationId conversationId,
            ChatMessageId messageId,
            AiModelId modelId,
            AiRunStatusId aiRunStatusId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageId = Objects.requireNonNull(messageId, "messageId must not be null");
        this.modelId = Objects.requireNonNull(modelId, "modelId must not be null");
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ChatAiRun register(
            ChatConversationId conversationId,
            ChatMessageId messageId,
            AiModelId modelId,
            AiRunStatusId aiRunStatusId) {
        ChatAiRunId id = ChatAiRunId.generate();
        ChatAiRun chatAiRun = new ChatAiRun(
                id,
                conversationId,
                messageId,
                modelId,
                aiRunStatusId,
                LocalDateTime.now(),
                null);
        chatAiRun.recordEvent(new ChatAiRunRegisteredEvent(id, LocalDateTime.now()));
        return chatAiRun;
    }

    public static ChatAiRun restore(
            ChatAiRunId id,
            ChatConversationId conversationId,
            ChatMessageId messageId,
            AiModelId modelId,
            AiRunStatusId aiRunStatusId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ChatAiRun(
                id,
                conversationId,
                messageId,
                modelId,
                aiRunStatusId,
                createdAt,
                updatedAt);
    }

    public void update(
            ChatConversationId conversationId,
            ChatMessageId messageId,
            AiModelId modelId,
            AiRunStatusId aiRunStatusId) {
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageId = Objects.requireNonNull(messageId, "messageId must not be null");
        this.modelId = Objects.requireNonNull(modelId, "modelId must not be null");
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatAiRunUpdatedEvent(
                id,
                this.conversationId,
                this.messageId,
                this.modelId,
                this.aiRunStatusId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatAiRunDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatAiRunId id() {
        return id;
    }

    public ChatConversationId conversationId() {
        return conversationId;
    }

    public ChatMessageId messageId() {
        return messageId;
    }

    public AiModelId modelId() {
        return modelId;
    }

    public AiRunStatusId aiRunStatusId() {
        return aiRunStatusId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
