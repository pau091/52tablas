package com.tarea.infrastructure.escalationstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record UpdateEscalationStatusRequest(
        @Size(max = 50) String nameStatus
) {
}
