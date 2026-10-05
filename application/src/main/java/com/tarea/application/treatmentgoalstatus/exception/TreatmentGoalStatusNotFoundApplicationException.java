package com.tarea.application.treatmentgoalstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentGoalStatusNotFoundApplicationException extends ApplicationException {

    public TreatmentGoalStatusNotFoundApplicationException(String id) {
        super("TreatmentGoalStatus not found with id: " + id);
    }
}
