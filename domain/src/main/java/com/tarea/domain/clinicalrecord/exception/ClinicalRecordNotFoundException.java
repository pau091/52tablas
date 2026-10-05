package com.tarea.domain.clinicalrecord.exception;

public class ClinicalRecordNotFoundException extends RuntimeException {

    public ClinicalRecordNotFoundException(String id) {
        super("ClinicalRecord not found with id: " + id);
    }
}
