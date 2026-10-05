package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class GetRiskAssessmentByIdUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public GetRiskAssessmentByIdUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public RiskAssessmentResponse execute(RiskAssessmentId id) {
        var riskAssessment = riskAssessmentRepository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id.value().toString()));
        return RiskAssessmentResponse.fromDomain(riskAssessment);
    }
}
