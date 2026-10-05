package com.tarea.infrastructure.priority.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record CreatePriorityRequest(
        @Size(max = 50) String namePriority
) {
}
