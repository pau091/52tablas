package com.tarea.infrastructure.phonecontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdatePhoneContactRequest(
        @NotNull UUID contactId,
        @Size(max = 30) String phone,
        String notes
) {
}
