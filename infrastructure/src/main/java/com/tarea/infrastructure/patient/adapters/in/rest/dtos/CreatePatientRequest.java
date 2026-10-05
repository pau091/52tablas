package com.tarea.infrastructure.patient.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record CreatePatientRequest(
        @NotNull UUID documentTypeId,
        @Size(max = 30) String documentNumber,
        @Size(max = 50) String firstName,
        @Size(max = 50) String middleName,
        @Size(max = 50) String lastName,
        @Size(max = 50) String secondLastName,
        LocalDate birthDate,
        @NotNull UUID biologicalSexId,
        @NotNull UUID genderIdentity,
        @NotBlank @Size(max = 150) String email,
        @Size(max = 30) String phone,
        @Size(max = 250) String address,
        Boolean active,
        UUID createdBy,
        UUID updatedBy,
        @NotNull UUID cityId
) {
}
