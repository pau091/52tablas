package com.tarea.domain.clinicalrecordstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalRecordStatusRegisteredEvent(ClinicalRecordStatusId id, LocalDateTime occurredOn) implements DomainEvent {

    public ClinicalRecordStatusRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
