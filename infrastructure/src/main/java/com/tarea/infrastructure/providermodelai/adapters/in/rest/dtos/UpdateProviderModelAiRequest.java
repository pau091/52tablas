package com.tarea.infrastructure.providermodelai.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record UpdateProviderModelAiRequest(
        @Size(max = 100) String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        Boolean isActive
) {
}
