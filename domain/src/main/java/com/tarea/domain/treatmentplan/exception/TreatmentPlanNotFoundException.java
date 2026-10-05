package com.tarea.domain.treatmentplan.exception;

public class TreatmentPlanNotFoundException extends RuntimeException {

    public TreatmentPlanNotFoundException(String id) {
        super("TreatmentPlan not found with id: " + id);
    }
}
