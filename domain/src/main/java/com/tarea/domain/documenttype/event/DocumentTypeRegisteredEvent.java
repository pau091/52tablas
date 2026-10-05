package com.tarea.domain.documenttype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record DocumentTypeRegisteredEvent(DocumentTypeId id, LocalDateTime occurredOn) implements DomainEvent {

    public DocumentTypeRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
