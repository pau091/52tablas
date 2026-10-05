package com.tarea.application.airunstatus.dto;

import com.tarea.domain.airunstatus.model.aggregate.AiRunStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AiRunStatusResponse(
        UUID id,
        String nameStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AiRunStatusResponse fromDomain(AiRunStatus aiRunStatus) {
        return new AiRunStatusResponse(
                aiRunStatus.id().value(),
                aiRunStatus.nameStatus(),
                aiRunStatus.createdAt(),
                aiRunStatus.updatedAt()
        );
    }
}
