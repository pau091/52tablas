package com.tarea.domain.clinicalrecordstatus.exception;

public class ClinicalRecordStatusNotFoundException extends RuntimeException {

    public ClinicalRecordStatusNotFoundException(String id) {
        super("ClinicalRecordStatus not found with id: " + id);
    }
}
