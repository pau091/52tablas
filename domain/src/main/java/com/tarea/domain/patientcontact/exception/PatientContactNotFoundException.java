package com.tarea.domain.patientcontact.exception;

public class PatientContactNotFoundException extends RuntimeException {

    public PatientContactNotFoundException(String id) {
        super("PatientContact not found with id: " + id);
    }
}
