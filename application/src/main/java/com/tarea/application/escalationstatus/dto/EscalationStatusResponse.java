package com.tarea.application.escalationstatus.dto;

import com.tarea.domain.escalationstatus.model.aggregate.EscalationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record EscalationStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static EscalationStatusResponse fromDomain(EscalationStatus escalationStatus) {
        return new EscalationStatusResponse(
                escalationStatus.id().value(),
                escalationStatus.nameStatus(),
                escalationStatus.createdAt(),
                escalationStatus.updatedAt()
        );
    }
}
