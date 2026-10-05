package com.tarea.domain.chatescalationstatushistory.model.aggregate;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryDeletedEvent;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryRegisteredEvent;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryUpdatedEvent;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatEscalationStatusHistory extends AggregateRoot {

    private final ChatEscalationStatusHistoryId id;
    private ChatEscalationId escalationId;
    private EscalationStatusId escalationStatusId;
    private final LocalDateTime createdAt;
    private LocalDateTime changedAt;

    private ChatEscalationStatusHistory(
            ChatEscalationStatusHistoryId id,
            ChatEscalationId escalationId,
            EscalationStatusId escalationStatusId,
            LocalDateTime createdAt,
            LocalDateTime changedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.changedAt = changedAt;
    }

    public static ChatEscalationStatusHistory register(ChatEscalationId escalationId, EscalationStatusId escalationStatusId, LocalDateTime changedAt) {
        ChatEscalationStatusHistoryId id = ChatEscalationStatusHistoryId.generate();
        ChatEscalationStatusHistory chatEscalationStatusHistory = new ChatEscalationStatusHistory(
                id,
                escalationId,
                escalationStatusId,
                LocalDateTime.now(),
                changedAt);
        chatEscalationStatusHistory.recordEvent(new ChatEscalationStatusHistoryRegisteredEvent(id, LocalDateTime.now()));
        return chatEscalationStatusHistory;
    }

    public static ChatEscalationStatusHistory restore(
            ChatEscalationStatusHistoryId id,
            ChatEscalationId escalationId,
            EscalationStatusId escalationStatusId,
            LocalDateTime createdAt,
            LocalDateTime changedAt) {
        return new ChatEscalationStatusHistory(
                id,
                escalationId,
                escalationStatusId,
                createdAt,
                changedAt);
    }

    public void update(ChatEscalationId escalationId, EscalationStatusId escalationStatusId, LocalDateTime changedAt) {
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        this.changedAt = changedAt;
        recordEvent(new ChatEscalationStatusHistoryUpdatedEvent(
                id,
                this.escalationId,
                this.escalationStatusId,
                this.changedAt,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatEscalationStatusHistoryDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatEscalationStatusHistoryId id() {
        return id;
    }

    public ChatEscalationId escalationId() {
        return escalationId;
    }

    public EscalationStatusId escalationStatusId() {
        return escalationStatusId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime changedAt() {
        return changedAt;
    }
}
