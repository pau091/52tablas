package com.tarea.infrastructure.patientcontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdatePatientContactRequest(
        @NotNull UUID contactId,
        @NotNull UUID patientId,
        Boolean isPrimaryContact,
        Boolean isEmergencyContact,
        @NotNull UUID relationshipTypeId
) {
}
