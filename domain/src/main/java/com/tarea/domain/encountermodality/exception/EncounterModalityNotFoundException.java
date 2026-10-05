package com.tarea.domain.encountermodality.exception;

public class EncounterModalityNotFoundException extends RuntimeException {

    public EncounterModalityNotFoundException(String id) {
        super("EncounterModality not found with id: " + id);
    }
}
