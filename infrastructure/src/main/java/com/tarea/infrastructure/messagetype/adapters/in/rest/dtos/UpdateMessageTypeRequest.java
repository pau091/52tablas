package com.tarea.infrastructure.messagetype.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record UpdateMessageTypeRequest(
        @Size(max = 50) String nameType
) {
}
