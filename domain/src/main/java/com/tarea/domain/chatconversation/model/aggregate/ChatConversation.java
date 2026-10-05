package com.tarea.domain.chatconversation.model.aggregate;

import com.tarea.domain.chatconversation.event.ChatConversationDeletedEvent;
import com.tarea.domain.chatconversation.event.ChatConversationRegisteredEvent;
import com.tarea.domain.chatconversation.event.ChatConversationUpdatedEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatConversation extends AggregateRoot {

    private final ChatConversationId id;
    private ConversationStatusId conversationStatusId;
    private PriorityId priorityId;
    private LocalDateTime lastMessageAt;
    private Boolean closed;
    private LocalDateTime closedAt;
    private UUID closedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatConversation(
            ChatConversationId id,
            ConversationStatusId conversationStatusId,
            PriorityId priorityId,
            LocalDateTime lastMessageAt,
            Boolean closed,
            LocalDateTime closedAt,
            UUID closedBy,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationStatusId = Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        this.priorityId = Objects.requireNonNull(priorityId, "priorityId must not be null");
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ChatConversation register(
            ConversationStatusId conversationStatusId,
            PriorityId priorityId,
            LocalDateTime lastMessageAt,
            Boolean closed,
            LocalDateTime closedAt,
            UUID closedBy) {
        ChatConversationId id = ChatConversationId.generate();
        ChatConversation chatConversation = new ChatConversation(
                id,
                conversationStatusId,
                priorityId,
                lastMessageAt,
                closed != null ? closed : Boolean.FALSE,
                closedAt,
                closedBy,
                LocalDateTime.now(),
                null);
        chatConversation.recordEvent(new ChatConversationRegisteredEvent(id, LocalDateTime.now()));
        return chatConversation;
    }

    public static ChatConversation restore(
            ChatConversationId id,
            ConversationStatusId conversationStatusId,
            PriorityId priorityId,
            LocalDateTime lastMessageAt,
            Boolean closed,
            LocalDateTime closedAt,
            UUID closedBy,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ChatConversation(
                id,
                conversationStatusId,
                priorityId,
                lastMessageAt,
                closed,
                closedAt,
                closedBy,
                createdAt,
                updatedAt);
    }

    public void update(
            ConversationStatusId conversationStatusId,
            PriorityId priorityId,
            LocalDateTime lastMessageAt,
            Boolean closed,
            LocalDateTime closedAt,
            UUID closedBy) {
        this.conversationStatusId = Objects.requireNonNull(conversationStatusId, "conversationStatusId must not be null");
        this.priorityId = Objects.requireNonNull(priorityId, "priorityId must not be null");
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatConversationUpdatedEvent(
                id,
                this.conversationStatusId,
                this.priorityId,
                this.lastMessageAt,
                this.closed,
                this.closedAt,
                this.closedBy,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatConversationDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatConversationId id() {
        return id;
    }

    public ConversationStatusId conversationStatusId() {
        return conversationStatusId;
    }

    public PriorityId priorityId() {
        return priorityId;
    }

    public LocalDateTime lastMessageAt() {
        return lastMessageAt;
    }

    public Boolean closed() {
        return closed;
    }

    public LocalDateTime closedAt() {
        return closedAt;
    }

    public UUID closedBy() {
        return closedBy;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
