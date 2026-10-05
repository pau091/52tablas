package com.tarea.domain.clinicalnote.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalNoteRegisteredEvent(ClinicalNoteId id, LocalDateTime occurredOn) implements DomainEvent {

    public ClinicalNoteRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
