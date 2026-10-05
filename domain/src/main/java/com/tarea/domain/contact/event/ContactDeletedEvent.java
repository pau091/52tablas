package com.tarea.domain.contact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ContactDeletedEvent(ContactId id, LocalDateTime occurredOn) implements DomainEvent {

    public ContactDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
