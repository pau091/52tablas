package com.tarea.application.providermodelai.dto;

import com.tarea.domain.providermodelai.model.aggregate.ProviderModelAi;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProviderModelAiResponse(
        UUID id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProviderModelAiResponse fromDomain(ProviderModelAi providerModelAi) {
        return new ProviderModelAiResponse(
                providerModelAi.id().value(),
                providerModelAi.nameProviderAi(),
                providerModelAi.razonSocial(),
                providerModelAi.sitioWeb(),
                providerModelAi.isActive(),
                providerModelAi.createdAt(),
                providerModelAi.updatedAt()
        );
    }
}
