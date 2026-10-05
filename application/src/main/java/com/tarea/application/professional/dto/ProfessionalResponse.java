package com.tarea.application.professional.dto;

import com.tarea.domain.professional.model.aggregate.Professional;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProfessionalResponse(
        UUID id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalType,
        String licenseNumber,
        Boolean active,
        UUID cityId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProfessionalResponse fromDomain(Professional professional) {
        return new ProfessionalResponse(
                professional.id().value(),
                professional.documentTypeId().value(),
                professional.documentNumber(),
                professional.firstName(),
                professional.lastName(),
                professional.professionalType().value(),
                professional.licenseNumber(),
                professional.active(),
                professional.cityId().value(),
                professional.createdAt(),
                professional.updatedAt()
        );
    }
}
