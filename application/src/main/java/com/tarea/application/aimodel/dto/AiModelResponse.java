package com.tarea.application.aimodel.dto;

import com.tarea.domain.aimodel.model.aggregate.AiModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AiModelResponse(
        UUID id,
        UUID providerModelId,
        String nameModel,
        String modelKey,
        BigDecimal inputTokenPrice,
        BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AiModelResponse fromDomain(AiModel aiModel) {
        return new AiModelResponse(
                aiModel.id().value(),
                aiModel.providerModelId().value(),
                aiModel.nameModel(),
                aiModel.modelKey(),
                aiModel.inputTokenPrice(),
                aiModel.outputTokenPrice(),
                aiModel.maxTokens(),
                aiModel.contextWindow(),
                aiModel.isActive(),
                aiModel.createdAt(),
                aiModel.updatedAt()
        );
    }
}
