package com.tarea.domain.encounter.exception;

public class EncounterNotFoundException extends RuntimeException {

    public EncounterNotFoundException(String id) {
        super("Encounter not found with id: " + id);
    }
}
