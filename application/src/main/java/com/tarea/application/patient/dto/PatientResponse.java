package com.tarea.application.patient.dto;

import com.tarea.domain.patient.model.aggregate.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record PatientResponse(
        UUID id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        Boolean active,
        LocalDateTime createdAt,
        UUID createdBy,
        LocalDateTime updatedAt,
        UUID updatedBy,
        UUID cityId
) {

    public static PatientResponse fromDomain(Patient patient) {
        return new PatientResponse(
                patient.id().value(),
                patient.documentTypeId().value(),
                patient.documentNumber(),
                patient.firstName(),
                patient.middleName(),
                patient.lastName(),
                patient.secondLastName(),
                patient.birthDate(),
                patient.biologicalSexId().value(),
                patient.genderIdentity().value(),
                patient.email(),
                patient.phone(),
                patient.address(),
                patient.active(),
                patient.createdAt(),
                patient.createdBy() != null ? patient.createdBy().value() : null,
                patient.updatedAt(),
                patient.updatedBy() != null ? patient.updatedBy().value() : null,
                patient.cityId().value()
        );
    }
}
