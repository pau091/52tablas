package com.tarea.application.riskassessment.exception;

import com.tarea.application.common.exception.ApplicationException;

public class RiskAssessmentNotFoundApplicationException extends ApplicationException {

    public RiskAssessmentNotFoundApplicationException(String id) {
        super("RiskAssessment not found with id: " + id);
    }
}
