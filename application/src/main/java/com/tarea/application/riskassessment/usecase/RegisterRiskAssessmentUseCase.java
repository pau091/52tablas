package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.command.RegisterRiskAssessmentCommand;
import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.domain.riskassessment.model.aggregate.RiskAssessment;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class RegisterRiskAssessmentUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public RegisterRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public RiskAssessmentResponse execute(RegisterRiskAssessmentCommand command) {
        RiskAssessment riskAssessment = RiskAssessment.register(
                command.encounterId(),
                command.riskLevelId(),
                command.suicidalIdeation(),
                command.suicidePlan(),
                command.suicideIntent(),
                command.selfHarm(),
                command.harmToOthers(),
                command.riskFactors(),
                command.protectiveFactors(),
                command.clinicalActions(),
                command.observations(),
                command.assessedAt(),
                command.assessedBy());
        RiskAssessment saved = riskAssessmentRepository.save(riskAssessment);
        return RiskAssessmentResponse.fromDomain(saved);
    }
}
