package com.tarea.application.treatmentplan.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentPlanNotFoundApplicationException extends ApplicationException {

    public TreatmentPlanNotFoundApplicationException(String id) {
        super("TreatmentPlan not found with id: " + id);
    }
}
