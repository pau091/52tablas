package com.tarea.infrastructure.riskassessment.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateRiskAssessmentRequest(
        @NotNull UUID encounterId,
        @NotNull UUID riskLevelId,
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
        @NotNull UUID assessedBy
) {
}
