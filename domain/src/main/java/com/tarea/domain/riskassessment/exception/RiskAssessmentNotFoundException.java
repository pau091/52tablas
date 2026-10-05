package com.tarea.domain.riskassessment.exception;

public class RiskAssessmentNotFoundException extends RuntimeException {

    public RiskAssessmentNotFoundException(String id) {
        super("RiskAssessment not found with id: " + id);
    }
}
