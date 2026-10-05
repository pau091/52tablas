package com.tarea.infrastructure.escalationstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record CreateEscalationStatusRequest(
        @Size(max = 50) String nameStatus
) {
}
