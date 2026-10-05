package com.tarea.application.riskassessment.dto;

import com.tarea.domain.riskassessment.model.aggregate.RiskAssessment;

import java.time.LocalDateTime;
import java.util.UUID;

public record RiskAssessmentResponse(
        UUID id,
        UUID encounterId,
        UUID riskLevelId,
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
        UUID assessedBy
) {

    public static RiskAssessmentResponse fromDomain(RiskAssessment riskAssessment) {
        return new RiskAssessmentResponse(
                riskAssessment.id().value(),
                riskAssessment.encounterId().value(),
                riskAssessment.riskLevelId().value(),
                riskAssessment.suicidalIdeation(),
                riskAssessment.suicidePlan(),
                riskAssessment.suicideIntent(),
                riskAssessment.selfHarm(),
                riskAssessment.harmToOthers(),
                riskAssessment.riskFactors(),
                riskAssessment.protectiveFactors(),
                riskAssessment.clinicalActions(),
                riskAssessment.observations(),
                riskAssessment.assessedAt(),
                riskAssessment.assessedBy().value()
        );
    }
}
