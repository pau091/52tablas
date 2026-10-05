package com.tarea.infrastructure.sendertype.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record CreateSenderTypeRequest(
        @Size(max = 50) String nameType
) {
}
