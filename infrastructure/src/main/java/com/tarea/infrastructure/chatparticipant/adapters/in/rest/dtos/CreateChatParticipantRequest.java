package com.tarea.infrastructure.chatparticipant.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateChatParticipantRequest(
        @NotNull UUID conversationId,
        @NotNull UUID participantTypeId,
        UUID patientId,
        UUID professionalId
) {
}
