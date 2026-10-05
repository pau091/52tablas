package com.tarea.domain.providermodelai.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProviderModelAiRegisteredEvent(ProviderModelAiId id, LocalDateTime occurredOn) implements DomainEvent {

    public ProviderModelAiRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
