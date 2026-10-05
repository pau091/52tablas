package com.tarea.domain.medicationroute.exception;

public class MedicationRouteNotFoundException extends RuntimeException {

    public MedicationRouteNotFoundException(String id) {
        super("MedicationRoute not found with id: " + id);
    }
}
