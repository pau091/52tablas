package com.tarea.application.encountermodality.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterModalityNotFoundApplicationException extends ApplicationException {

    public EncounterModalityNotFoundApplicationException(String id) {
        super("EncounterModality not found with id: " + id);
    }
}
