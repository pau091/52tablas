package com.tarea.domain.treatmentplan.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentPlanUpdatedEvent(
        TreatmentPlanId id,
        EncounterId encounterId,
        ProfessionalId professionalId,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        TreatmentStatusId treatmentStatusId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public TreatmentPlanUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
