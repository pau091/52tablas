package com.tarea.infrastructure.contact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateContactRequest(
        @Size(max = 200) String fullName,
        @Size(max = 150) String email,
        String notes,
        @NotNull UUID cityId,
        @NotNull UUID createdBy,
        UUID updatedBy
) {
}
