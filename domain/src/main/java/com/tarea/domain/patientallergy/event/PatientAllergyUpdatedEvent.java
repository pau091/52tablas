package com.tarea.domain.patientallergy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public record PatientAllergyUpdatedEvent(
        PatientAllergyId id,
        PatientId patientId,
        String substance,
        String reaction,
        String severity,
        Boolean active,
        LocalDateTime recordedAt,
        UUID recordedBy,
        LocalDateTime occurredOn
) implements DomainEvent {

    public PatientAllergyUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
