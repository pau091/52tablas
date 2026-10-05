package com.tarea.infrastructure.conversationstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record UpdateConversationStatusRequest(
        @Size(max = 50) String nameStatus
) {
}
