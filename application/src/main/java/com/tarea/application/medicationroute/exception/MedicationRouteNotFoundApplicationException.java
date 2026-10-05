package com.tarea.application.medicationroute.exception;

import com.tarea.application.common.exception.ApplicationException;

public class MedicationRouteNotFoundApplicationException extends ApplicationException {

    public MedicationRouteNotFoundApplicationException(String id) {
        super("MedicationRoute not found with id: " + id);
    }
}
