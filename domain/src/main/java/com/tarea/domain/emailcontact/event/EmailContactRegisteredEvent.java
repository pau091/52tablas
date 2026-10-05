package com.tarea.domain.emailcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EmailContactRegisteredEvent(EmailContactId id, LocalDateTime occurredOn) implements DomainEvent {

    public EmailContactRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
