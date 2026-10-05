package com.tarea.domain.mentalstatusexam.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MentalStatusExamRegisteredEvent(MentalStatusExamId id, LocalDateTime occurredOn) implements DomainEvent {

    public MentalStatusExamRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
