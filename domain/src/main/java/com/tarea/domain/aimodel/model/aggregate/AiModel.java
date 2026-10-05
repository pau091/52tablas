package com.tarea.domain.aimodel.model.aggregate;

import com.tarea.domain.aimodel.event.AiModelDeletedEvent;
import com.tarea.domain.aimodel.event.AiModelRegisteredEvent;
import com.tarea.domain.aimodel.event.AiModelUpdatedEvent;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class AiModel extends AggregateRoot {

    private final AiModelId id;
    private ProviderModelAiId providerModelId;
    private String nameModel;
    private String modelKey;
    private BigDecimal inputTokenPrice;
    private BigDecimal outputTokenPrice;
    private Integer maxTokens;
    private Integer contextWindow;
    private Boolean isActive;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiModel(
            AiModelId id,
            ProviderModelAiId providerModelId,
            String nameModel,
            String modelKey,
            BigDecimal inputTokenPrice,
            BigDecimal outputTokenPrice,
            Integer maxTokens,
            Integer contextWindow,
            Boolean isActive,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.providerModelId = Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.isActive = isActive;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static AiModel register(
            ProviderModelAiId providerModelId,
            String nameModel,
            String modelKey,
            BigDecimal inputTokenPrice,
            BigDecimal outputTokenPrice,
            Integer maxTokens,
            Integer contextWindow,
            Boolean isActive) {
        AiModelId id = AiModelId.generate();
        AiModel aiModel = new AiModel(
                id,
                providerModelId,
                nameModel,
                modelKey,
                inputTokenPrice,
                outputTokenPrice,
                maxTokens,
                contextWindow,
                isActive != null ? isActive : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        aiModel.recordEvent(new AiModelRegisteredEvent(id, LocalDateTime.now()));
        return aiModel;
    }

    public static AiModel restore(
            AiModelId id,
            ProviderModelAiId providerModelId,
            String nameModel,
            String modelKey,
            BigDecimal inputTokenPrice,
            BigDecimal outputTokenPrice,
            Integer maxTokens,
            Integer contextWindow,
            Boolean isActive,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new AiModel(
                id,
                providerModelId,
                nameModel,
                modelKey,
                inputTokenPrice,
                outputTokenPrice,
                maxTokens,
                contextWindow,
                isActive,
                createdAt,
                updatedAt);
    }

    public void update(
            ProviderModelAiId providerModelId,
            String nameModel,
            String modelKey,
            BigDecimal inputTokenPrice,
            BigDecimal outputTokenPrice,
            Integer maxTokens,
            Integer contextWindow,
            Boolean isActive) {
        this.providerModelId = Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.isActive = isActive;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AiModelUpdatedEvent(
                id,
                this.providerModelId,
                this.nameModel,
                this.modelKey,
                this.inputTokenPrice,
                this.outputTokenPrice,
                this.maxTokens,
                this.contextWindow,
                this.isActive,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new AiModelDeletedEvent(id, LocalDateTime.now()));
    }

    public AiModelId id() {
        return id;
    }

    public ProviderModelAiId providerModelId() {
        return providerModelId;
    }

    public String nameModel() {
        return nameModel;
    }

    public String modelKey() {
        return modelKey;
    }

    public BigDecimal inputTokenPrice() {
        return inputTokenPrice;
    }

    public BigDecimal outputTokenPrice() {
        return outputTokenPrice;
    }

    public Integer maxTokens() {
        return maxTokens;
    }

    public Integer contextWindow() {
        return contextWindow;
    }

    public Boolean isActive() {
        return isActive;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
