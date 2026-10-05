package com.tarea.domain.patientallergy.exception;

public class PatientAllergyNotFoundException extends RuntimeException {

    public PatientAllergyNotFoundException(String id) {
        super("PatientAllergy not found with id: " + id);
    }
}
