package com.tarea.application.treatmentstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentStatusNotFoundApplicationException extends ApplicationException {

    public TreatmentStatusNotFoundApplicationException(String id) {
        super("TreatmentStatus not found with id: " + id);
    }
}
