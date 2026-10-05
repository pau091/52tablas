package com.tarea.application.patientallergy.dto;

import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;

import java.time.LocalDateTime;
import java.util.UUID;

public record PatientAllergyResponse(
        UUID id,
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        Boolean active,
        LocalDateTime recordedAt,
        UUID recordedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static PatientAllergyResponse fromDomain(PatientAllergy patientAllergy) {
        return new PatientAllergyResponse(
                patientAllergy.id().value(),
                patientAllergy.patientId().value(),
                patientAllergy.substance(),
                patientAllergy.reaction(),
                patientAllergy.severity(),
                patientAllergy.active(),
                patientAllergy.recordedAt(),
                patientAllergy.recordedBy(),
                patientAllergy.createdAt(),
                patientAllergy.updatedAt()
        );
    }
}
