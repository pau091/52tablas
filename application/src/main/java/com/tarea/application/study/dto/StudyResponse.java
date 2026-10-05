package com.tarea.application.study.dto;

import com.tarea.domain.study.model.aggregate.Study;

import java.time.LocalDateTime;
import java.util.UUID;

public record StudyResponse(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static StudyResponse fromDomain(Study study) {
        return new StudyResponse(
                study.id().value(),
                study.name(),
                study.createdAt(),
                study.updatedAt()
        );
    }
}
