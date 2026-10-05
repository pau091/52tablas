package com.tarea.domain.chatparticipant.event;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatParticipantUpdatedEvent(
        ChatParticipantId id,
        ChatConversationId conversationId,
        SenderTypeId participantTypeId,
        PatientId patientId,
        ProfessionalId professionalId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ChatParticipantUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
