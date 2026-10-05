package com.tarea.domain.clinicalrecordstatus.event;

import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalRecordStatusUpdatedEvent(
        ClinicalRecordStatusId id,
        String code,
        String name,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ClinicalRecordStatusUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
