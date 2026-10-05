package com.tarea.application.escalationstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EscalationStatusNotFoundApplicationException extends ApplicationException {

    public EscalationStatusNotFoundApplicationException(String id) {
        super("EscalationStatus not found with id: " + id);
    }
}
