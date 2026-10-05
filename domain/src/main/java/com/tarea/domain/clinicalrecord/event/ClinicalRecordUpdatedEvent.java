package com.tarea.domain.clinicalrecord.event;

import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalRecordUpdatedEvent(
        ClinicalRecordId id,
        PatientId patientId,
        LocalDateTime creationDate,
        String recordNumber,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        ClinicalRecordStatusId statusId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ClinicalRecordUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
