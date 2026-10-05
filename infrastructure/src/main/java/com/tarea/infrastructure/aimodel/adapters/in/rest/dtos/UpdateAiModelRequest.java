package com.tarea.infrastructure.aimodel.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateAiModelRequest(
        @NotNull UUID providerModelId,
        @Size(max = 100) String nameModel,
        @Size(max = 120) String modelKey,
        BigDecimal inputTokenPrice,
        BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        Boolean isActive
) {
}
