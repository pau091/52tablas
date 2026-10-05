package com.tarea.domain.encounter.event;

import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public record EncounterUpdatedEvent(
        EncounterId id,
        ClinicalRecordId clinicalRecordId,
        ProfessionalId professionalId,
        EncounterTypeId encounterTypeId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        EncounterModalityId modalityId,
        EncounterStatusId statusId,
        UUID updatedBy,
        LocalDateTime occurredOn
) implements DomainEvent {

    public EncounterUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
