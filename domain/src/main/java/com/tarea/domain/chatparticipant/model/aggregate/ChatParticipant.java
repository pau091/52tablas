package com.tarea.domain.chatparticipant.model.aggregate;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.event.ChatParticipantDeletedEvent;
import com.tarea.domain.chatparticipant.event.ChatParticipantRegisteredEvent;
import com.tarea.domain.chatparticipant.event.ChatParticipantUpdatedEvent;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatParticipant extends AggregateRoot {

    private final ChatParticipantId id;
    private ChatConversationId conversationId;
    private SenderTypeId participantTypeId;
    private PatientId patientId;
    private ProfessionalId professionalId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatParticipant(
            ChatParticipantId id,
            ChatConversationId conversationId,
            SenderTypeId participantTypeId,
            PatientId patientId,
            ProfessionalId professionalId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.participantTypeId = Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
        this.patientId = patientId;
        this.professionalId = professionalId;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ChatParticipant register(
            ChatConversationId conversationId,
            SenderTypeId participantTypeId,
            PatientId patientId,
            ProfessionalId professionalId) {
        ChatParticipantId id = ChatParticipantId.generate();
        ChatParticipant chatParticipant = new ChatParticipant(
                id,
                conversationId,
                participantTypeId,
                patientId,
                professionalId,
                LocalDateTime.now(),
                null);
        chatParticipant.recordEvent(new ChatParticipantRegisteredEvent(id, LocalDateTime.now()));
        return chatParticipant;
    }

    public static ChatParticipant restore(
            ChatParticipantId id,
            ChatConversationId conversationId,
            SenderTypeId participantTypeId,
            PatientId patientId,
            ProfessionalId professionalId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ChatParticipant(
                id,
                conversationId,
                participantTypeId,
                patientId,
                professionalId,
                createdAt,
                updatedAt);
    }

    public void update(
            ChatConversationId conversationId,
            SenderTypeId participantTypeId,
            PatientId patientId,
            ProfessionalId professionalId) {
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.participantTypeId = Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
        this.patientId = patientId;
        this.professionalId = professionalId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatParticipantUpdatedEvent(
                id,
                this.conversationId,
                this.participantTypeId,
                this.patientId,
                this.professionalId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatParticipantDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatParticipantId id() {
        return id;
    }

    public ChatConversationId conversationId() {
        return conversationId;
    }

    public SenderTypeId participantTypeId() {
        return participantTypeId;
    }

    public PatientId patientId() {
        return patientId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
