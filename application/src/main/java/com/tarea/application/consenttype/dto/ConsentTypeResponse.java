package com.tarea.application.consenttype.dto;

import com.tarea.domain.consenttype.model.aggregate.ConsentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsentTypeResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ConsentTypeResponse fromDomain(ConsentType consentType) {
        return new ConsentTypeResponse(
                consentType.id().value(),
                consentType.code(),
                consentType.name(),
                consentType.active(),
                consentType.description(),
                consentType.createdAt(),
                consentType.updatedAt()
        );
    }
}
