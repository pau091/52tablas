package com.tarea.domain.treatmentgoal.exception;

public class TreatmentGoalNotFoundException extends RuntimeException {

    public TreatmentGoalNotFoundException(String id) {
        super("TreatmentGoal not found with id: " + id);
    }
}
