package com.tarea.domain.diagnosticsystem.exception;

public class DiagnosticSystemNotFoundException extends RuntimeException {

    public DiagnosticSystemNotFoundException(String id) {
        super("DiagnosticSystem not found with id: " + id);
    }
}
