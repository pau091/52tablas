package com.tarea.domain.encounterstatus.exception;

public class EncounterStatusNotFoundException extends RuntimeException {

    public EncounterStatusNotFoundException(String id) {
        super("EncounterStatus not found with id: " + id);
    }
}
