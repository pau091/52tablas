package com.tarea.application.chatescalationstatushistory.dto;

import com.tarea.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChatEscalationStatusHistoryResponse(
        UUID id,
        UUID escalationId,
        UUID escalationStatusId,
        LocalDateTime createdAt,
        LocalDateTime changedAt
) {

    public static ChatEscalationStatusHistoryResponse fromDomain(ChatEscalationStatusHistory chatEscalationStatusHistory) {
        return new ChatEscalationStatusHistoryResponse(
                chatEscalationStatusHistory.id().value(),
                chatEscalationStatusHistory.escalationId().value(),
                chatEscalationStatusHistory.escalationStatusId().value(),
                chatEscalationStatusHistory.createdAt(),
                chatEscalationStatusHistory.changedAt()
        );
    }
}
