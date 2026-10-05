package com.tarea.domain.phonecontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PhoneContactRegisteredEvent(PhoneContactId id, LocalDateTime occurredOn) implements DomainEvent {

    public PhoneContactRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
