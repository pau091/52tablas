package com.tarea.domain.professionaltype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalTypeRegisteredEvent(ProfessionalTypeId id, LocalDateTime occurredOn) implements DomainEvent {

    public ProfessionalTypeRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
