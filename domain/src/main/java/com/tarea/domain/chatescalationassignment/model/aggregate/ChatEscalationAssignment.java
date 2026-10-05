package com.tarea.domain.chatescalationassignment.model.aggregate;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalationassignment.event.ChatEscalationAssignmentDeletedEvent;
import com.tarea.domain.chatescalationassignment.event.ChatEscalationAssignmentRegisteredEvent;
import com.tarea.domain.chatescalationassignment.event.ChatEscalationAssignmentUpdatedEvent;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatEscalationAssignment extends AggregateRoot {

    private final ChatEscalationAssignmentId id;
    private ChatEscalationId escalationId;
    private ProfessionalId professionalId;
    private LocalDateTime assignedAt;

    private ChatEscalationAssignment(
            ChatEscalationAssignmentId id,
            ChatEscalationId escalationId,
            ProfessionalId professionalId,
            LocalDateTime assignedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.assignedAt = assignedAt;
    }

    public static ChatEscalationAssignment register(ChatEscalationId escalationId, ProfessionalId professionalId, LocalDateTime assignedAt) {
        ChatEscalationAssignmentId id = ChatEscalationAssignmentId.generate();
        ChatEscalationAssignment chatEscalationAssignment = new ChatEscalationAssignment(
                id,
                escalationId,
                professionalId,
                assignedAt);
        chatEscalationAssignment.recordEvent(new ChatEscalationAssignmentRegisteredEvent(id, LocalDateTime.now()));
        return chatEscalationAssignment;
    }

    public static ChatEscalationAssignment restore(
            ChatEscalationAssignmentId id,
            ChatEscalationId escalationId,
            ProfessionalId professionalId,
            LocalDateTime assignedAt) {
        return new ChatEscalationAssignment(
                id,
                escalationId,
                professionalId,
                assignedAt);
    }

    public void update(ChatEscalationId escalationId, ProfessionalId professionalId, LocalDateTime assignedAt) {
        this.escalationId = Objects.requireNonNull(escalationId, "escalationId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.assignedAt = assignedAt;
        recordEvent(new ChatEscalationAssignmentUpdatedEvent(
                id,
                this.escalationId,
                this.professionalId,
                this.assignedAt,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatEscalationAssignmentDeletedEvent(id, LocalDateTime.now()));
    }

    public ChatEscalationAssignmentId id() {
        return id;
    }

    public ChatEscalationId escalationId() {
        return escalationId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public LocalDateTime assignedAt() {
        return assignedAt;
    }
}
