package com.tarea.domain.providermodelai.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProviderModelAiUpdatedEvent(
        ProviderModelAiId id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        Boolean isActive,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ProviderModelAiUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
