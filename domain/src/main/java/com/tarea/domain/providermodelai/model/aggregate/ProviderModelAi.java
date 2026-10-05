package com.tarea.domain.providermodelai.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.providermodelai.event.ProviderModelAiDeletedEvent;
import com.tarea.domain.providermodelai.event.ProviderModelAiRegisteredEvent;
import com.tarea.domain.providermodelai.event.ProviderModelAiUpdatedEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProviderModelAi extends AggregateRoot {

    private final ProviderModelAiId id;
    private String nameProviderAi;
    private String razonSocial;
    private String sitioWeb;
    private Boolean isActive;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProviderModelAi(
            ProviderModelAiId id,
            String nameProviderAi,
            String razonSocial,
            String sitioWeb,
            Boolean isActive,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameProviderAi = nameProviderAi;
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.isActive = isActive;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ProviderModelAi register(
            String nameProviderAi,
            String razonSocial,
            String sitioWeb,
            Boolean isActive) {
        ProviderModelAiId id = ProviderModelAiId.generate();
        ProviderModelAi providerModelAi = new ProviderModelAi(
                id,
                nameProviderAi,
                razonSocial,
                sitioWeb,
                isActive != null ? isActive : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        providerModelAi.recordEvent(new ProviderModelAiRegisteredEvent(id, LocalDateTime.now()));
        return providerModelAi;
    }

    public static ProviderModelAi restore(
            ProviderModelAiId id,
            String nameProviderAi,
            String razonSocial,
            String sitioWeb,
            Boolean isActive,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ProviderModelAi(
                id,
                nameProviderAi,
                razonSocial,
                sitioWeb,
                isActive,
                createdAt,
                updatedAt);
    }

    public void update(
            String nameProviderAi,
            String razonSocial,
            String sitioWeb,
            Boolean isActive) {
        this.nameProviderAi = nameProviderAi;
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.isActive = isActive;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProviderModelAiUpdatedEvent(
                id,
                this.nameProviderAi,
                this.razonSocial,
                this.sitioWeb,
                this.isActive,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ProviderModelAiDeletedEvent(id, LocalDateTime.now()));
    }

    public ProviderModelAiId id() {
        return id;
    }

    public String nameProviderAi() {
        return nameProviderAi;
    }

    public String razonSocial() {
        return razonSocial;
    }

    public String sitioWeb() {
        return sitioWeb;
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
