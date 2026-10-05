package com.tarea.application.diagnosticsystem.exception;

import com.tarea.application.common.exception.ApplicationException;

public class DiagnosticSystemNotFoundApplicationException extends ApplicationException {

    public DiagnosticSystemNotFoundApplicationException(String id) {
        super("DiagnosticSystem not found with id: " + id);
    }
}
