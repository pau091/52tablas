package com.tarea.domain.encountertype.exception;

public class EncounterTypeNotFoundException extends RuntimeException {

    public EncounterTypeNotFoundException(String id) {
        super("EncounterType not found with id: " + id);
    }
}
