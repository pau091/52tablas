package com.tarea.domain.consenttype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ConsentTypeUpdatedEvent(
        ConsentTypeId id,
        String code,
        String name,
        Boolean active,
        String description,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ConsentTypeUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
