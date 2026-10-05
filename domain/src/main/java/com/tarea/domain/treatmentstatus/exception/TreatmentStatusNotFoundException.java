package com.tarea.domain.treatmentstatus.exception;

public class TreatmentStatusNotFoundException extends RuntimeException {

    public TreatmentStatusNotFoundException(String id) {
        super("TreatmentStatus not found with id: " + id);
    }
}
