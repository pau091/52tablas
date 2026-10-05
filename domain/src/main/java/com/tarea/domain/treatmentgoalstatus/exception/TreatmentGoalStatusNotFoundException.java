package com.tarea.domain.treatmentgoalstatus.exception;

public class TreatmentGoalStatusNotFoundException extends RuntimeException {

    public TreatmentGoalStatusNotFoundException(String id) {
        super("TreatmentGoalStatus not found with id: " + id);
    }
}
