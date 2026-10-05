package com.tarea.application.priority.dto;

import com.tarea.domain.priority.model.aggregate.Priority;

import java.time.LocalDateTime;
import java.util.UUID;

public record PriorityResponse(
        UUID id,
        String namePriority,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static PriorityResponse fromDomain(Priority priority) {
        return new PriorityResponse(
                priority.id().value(),
                priority.namePriority(),
                priority.createdAt(),
                priority.updatedAt()
        );
    }
}
