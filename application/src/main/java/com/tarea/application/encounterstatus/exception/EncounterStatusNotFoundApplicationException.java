package com.tarea.application.encounterstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterStatusNotFoundApplicationException extends ApplicationException {

    public EncounterStatusNotFoundApplicationException(String id) {
        super("EncounterStatus not found with id: " + id);
    }
}
