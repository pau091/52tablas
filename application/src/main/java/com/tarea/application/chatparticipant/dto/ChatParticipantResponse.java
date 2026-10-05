package com.tarea.application.chatparticipant.dto;

import com.tarea.domain.chatparticipant.model.aggregate.ChatParticipant;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatParticipantResponse(
        UUID id,
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ChatParticipantResponse fromDomain(ChatParticipant chatParticipant) {
        return new ChatParticipantResponse(
                chatParticipant.id().value(),
                chatParticipant.conversationId().value(),
                chatParticipant.participantTypeId().value(),
                chatParticipant.patientId() != null ? chatParticipant.patientId().value() : null,
                chatParticipant.professionalId() != null ? chatParticipant.professionalId().value() : null,
                chatParticipant.createdAt(),
                chatParticipant.updatedAt()
        );
    }
}
