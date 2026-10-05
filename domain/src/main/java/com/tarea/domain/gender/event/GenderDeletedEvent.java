package com.tarea.domain.gender.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.gender.model.valueobject.GenderId;

import java.time.LocalDateTime;
import java.util.Objects;

public record GenderDeletedEvent(GenderId id, LocalDateTime occurredOn) implements DomainEvent {

    public GenderDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
