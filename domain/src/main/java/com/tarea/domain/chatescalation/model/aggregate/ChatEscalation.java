package com.tarea.domain.chatescalation.model.aggregate;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatescalation.event.ChatEscalationDeletedEvent;
import com.tarea.domain.chatescalation.event.ChatEscalationRegisteredEvent;
import com.tarea.domain.chatescalation.event.ChatEscalationUpdatedEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatEscalation extends AggregateRoot {

    private final ChatEscalationId id;
    private ChatConversationId conversationId;
    private EscalationStatusId statusId;
    private Boolean fromAi;
    private String reason;
    private final LocalDateTime createdAt;

    private ChatEscalation(
            ChatEscalationId id,
            ChatConversationId conversationId,
            EscalationStatusId statusId,
            Boolean fromAi,
            String reason,
            LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.fromAi = fromAi;
        this.reason = reason;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public static ChatEscalation register(
            ChatConversationId conversationId,
            EscalationStatusId statusId,
            Boolean fromAi,
            String reason) {
        ChatEscalationId id = ChatEscalationId.generate();
        ChatEscalation chatEscalation = new ChatEscalation(
                id,
                conversationId,
                statusId,
                fromAi != null ? fromAi : Boolean.FALSE,
                reason,
                LocalDateTime.now());
        chatEscalation.recordEvent(new ChatEscalationRegisteredEvent(id, LocalDateTime.now()));
        return chatEscalation;
    }

    public static ChatEscalation restore(
            ChatEscalationId id,
            ChatConversationId conversationId,
            EscalationStatusId statusId,
            Boolean fromAi,
            String reason,
            LocalDateTime createdAt) {
        return new ChatEscalation(
                id,
                conversationId,
                statusId,
                fromAi,
                reason,
                createdAt);
    }

    public void update(
            ChatConversationId conversationId,
            EscalationStatusId statusId,
            Boolean fromAi,
            String reason) {
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.fromAi = fromAi;
        this.reason = reason;
        recordEvent(new ChatEscalationUpdatedEvent(
                id,
                this.conversationId,
                this.statusId,
                this.fromAi,
                this.reason,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatEscalationDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatEscalationId id() {
        return id;
    }

    public ChatConversationId conversationId() {
        return conversationId;
    }

    public EscalationStatusId statusId() {
        return statusId;
    }

    public Boolean fromAi() {
        return fromAi;
    }

    public String reason() {
        return reason;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }
}
