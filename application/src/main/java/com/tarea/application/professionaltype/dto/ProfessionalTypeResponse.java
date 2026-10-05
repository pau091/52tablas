package com.tarea.application.professionaltype.dto;

import com.tarea.domain.professionaltype.model.aggregate.ProfessionalType;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProfessionalTypeResponse(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProfessionalTypeResponse fromDomain(ProfessionalType professionalType) {
        return new ProfessionalTypeResponse(
                professionalType.id().value(),
                professionalType.name(),
                professionalType.createdAt(),
                professionalType.updatedAt()
        );
    }
}
