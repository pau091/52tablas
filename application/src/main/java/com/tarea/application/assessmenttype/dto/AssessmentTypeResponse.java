package com.tarea.application.assessmenttype.dto;

import com.tarea.domain.assessmenttype.model.aggregate.AssessmentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssessmentTypeResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AssessmentTypeResponse fromDomain(AssessmentType assessmentType) {
        return new AssessmentTypeResponse(
                assessmentType.id().value(),
                assessmentType.code(),
                assessmentType.name(),
                assessmentType.active(),
                assessmentType.description(),
                assessmentType.createdAt(),
                assessmentType.updatedAt()
        );
    }
}
