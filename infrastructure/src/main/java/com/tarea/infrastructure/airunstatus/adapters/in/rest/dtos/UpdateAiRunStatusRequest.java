package com.tarea.infrastructure.airunstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record UpdateAiRunStatusRequest(
        @Size(max = 50) String nameStatus
) {
}
