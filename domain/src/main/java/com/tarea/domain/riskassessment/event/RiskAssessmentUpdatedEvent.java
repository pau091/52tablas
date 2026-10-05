package com.tarea.domain.riskassessment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskAssessmentUpdatedEvent(
        RiskAssessmentId id,
        EncounterId encounterId,
        RiskLevelId riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String riskFactors,
        String protectiveFactors,
        String clinicalActions,
        String observations,
        LocalDateTime assessedAt,
        ProfessionalId assessedBy,
        LocalDateTime occurredOn
) implements DomainEvent {

    public RiskAssessmentUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
