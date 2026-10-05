package com.tarea.domain.clinicalnote.event;

import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalNoteUpdatedEvent(
        ClinicalNoteId id,
        EncounterId encounterId,
        ProfessionalId professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        LocalDateTime signedAt,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ClinicalNoteUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
