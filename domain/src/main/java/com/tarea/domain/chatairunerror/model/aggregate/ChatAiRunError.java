package com.tarea.domain.chatairunerror.model.aggregate;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorDeletedEvent;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorRegisteredEvent;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorUpdatedEvent;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatAiRunError extends AggregateRoot {

    private final ChatAiRunErrorId id;
    private ChatAiRunId aiRunId;
    private String errorMessage;
    private String errorCode;
    private String providerErrorId;
    private final LocalDateTime createdAt;

    private ChatAiRunError(
            ChatAiRunErrorId id,
            ChatAiRunId aiRunId,
            String errorMessage,
            String errorCode,
            String providerErrorId,
            LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.aiRunId = Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public static ChatAiRunError register(
            ChatAiRunId aiRunId,
            String errorMessage,
            String errorCode,
            String providerErrorId) {
        ChatAiRunErrorId id = ChatAiRunErrorId.generate();
        ChatAiRunError chatAiRunError = new ChatAiRunError(
                id,
                aiRunId,
                errorMessage,
                errorCode,
                providerErrorId,
                LocalDateTime.now());
        chatAiRunError.recordEvent(new ChatAiRunErrorRegisteredEvent(id, LocalDateTime.now()));
        return chatAiRunError;
    }

    public static ChatAiRunError restore(
            ChatAiRunErrorId id,
            ChatAiRunId aiRunId,
            String errorMessage,
            String errorCode,
            String providerErrorId,
            LocalDateTime createdAt) {
        return new ChatAiRunError(
                id,
                aiRunId,
                errorMessage,
                errorCode,
                providerErrorId,
                createdAt);
    }

    public void update(
            ChatAiRunId aiRunId,
            String errorMessage,
            String errorCode,
            String providerErrorId) {
        this.aiRunId = Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        recordEvent(new ChatAiRunErrorUpdatedEvent(
                id,
                this.aiRunId,
                this.errorMessage,
                this.errorCode,
                this.providerErrorId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatAiRunErrorDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatAiRunErrorId id() {
        return id;
    }

    public ChatAiRunId aiRunId() {
        return aiRunId;
    }

    public String errorMessage() {
        return errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String providerErrorId() {
        return providerErrorId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }
}
