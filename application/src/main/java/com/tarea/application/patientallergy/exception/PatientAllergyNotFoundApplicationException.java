package com.tarea.application.patientallergy.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PatientAllergyNotFoundApplicationException extends ApplicationException {

    public PatientAllergyNotFoundApplicationException(String id) {
        super("PatientAllergy not found with id: " + id);
    }
}
