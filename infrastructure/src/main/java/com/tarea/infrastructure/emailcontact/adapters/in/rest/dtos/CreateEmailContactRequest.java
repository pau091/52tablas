package com.tarea.infrastructure.emailcontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateEmailContactRequest(
        @NotNull UUID contactId,
        @NotBlank @Size(max = 150) String email,
        String notes
) {
}
