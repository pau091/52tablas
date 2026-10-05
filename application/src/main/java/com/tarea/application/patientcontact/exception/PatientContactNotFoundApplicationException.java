package com.tarea.application.patientcontact.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PatientContactNotFoundApplicationException extends ApplicationException {

    public PatientContactNotFoundApplicationException(String id) {
        super("PatientContact not found with id: " + id);
    }
}
