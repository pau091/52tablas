package com.tarea.infrastructure.airunstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record CreateAiRunStatusRequest(
        @Size(max = 50) String nameStatus
) {
}
