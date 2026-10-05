package com.tarea.domain.chatmessage.model.aggregate;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.event.ChatMessageDeletedEvent;
import com.tarea.domain.chatmessage.event.ChatMessageRegisteredEvent;
import com.tarea.domain.chatmessage.event.ChatMessageUpdatedEvent;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatMessage extends AggregateRoot {

    private final ChatMessageId id;
    private ChatConversationId conversationId;
    private MessageTypeId messageTypeId;
    private ChatParticipantId participantId;
    private String content;
    private String metadata;
    private final LocalDateTime createdAt;

    private ChatMessage(
            ChatMessageId id,
            ChatConversationId conversationId,
            MessageTypeId messageTypeId,
            ChatParticipantId participantId,
            String content,
            String metadata,
            LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageTypeId = Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        this.participantId = Objects.requireNonNull(participantId, "participantId must not be null");
        this.content = content;
        this.metadata = metadata;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public static ChatMessage register(
            ChatConversationId conversationId,
            MessageTypeId messageTypeId,
            ChatParticipantId participantId,
            String content,
            String metadata) {
        ChatMessageId id = ChatMessageId.generate();
        ChatMessage chatMessage = new ChatMessage(
                id,
                conversationId,
                messageTypeId,
                participantId,
                content,
                metadata,
                LocalDateTime.now());
        chatMessage.recordEvent(new ChatMessageRegisteredEvent(id, LocalDateTime.now()));
        return chatMessage;
    }

    public static ChatMessage restore(
            ChatMessageId id,
            ChatConversationId conversationId,
            MessageTypeId messageTypeId,
            ChatParticipantId participantId,
            String content,
            String metadata,
            LocalDateTime createdAt) {
        return new ChatMessage(
                id,
                conversationId,
                messageTypeId,
                participantId,
                content,
                metadata,
                createdAt);
    }

    public void update(
            ChatConversationId conversationId,
            MessageTypeId messageTypeId,
            ChatParticipantId participantId,
            String content,
            String metadata) {
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.messageTypeId = Objects.requireNonNull(messageTypeId, "messageTypeId must not be null");
        this.participantId = Objects.requireNonNull(participantId, "participantId must not be null");
        this.content = content;
        this.metadata = metadata;
        recordEvent(new ChatMessageUpdatedEvent(
                id,
                this.conversationId,
                this.messageTypeId,
                this.participantId,
                this.content,
                this.metadata,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatMessageDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatMessageId id() {
        return id;
    }

    public ChatConversationId conversationId() {
        return conversationId;
    }

    public MessageTypeId messageTypeId() {
        return messageTypeId;
    }

    public ChatParticipantId participantId() {
        return participantId;
    }

    public String content() {
        return content;
    }

    public String metadata() {
        return metadata;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }
}
