package com.tarea.domain.aimodel.event;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public record AiModelUpdatedEvent(
        AiModelId id,
        ProviderModelAiId providerModelId,
        String nameModel,
        String modelKey,
        BigDecimal inputTokenPrice,
        BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        Boolean isActive,
        LocalDateTime occurredOn
) implements DomainEvent {

    public AiModelUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
