package com.tarea.domain.escalationstatus.exception;

public class EscalationStatusNotFoundException extends RuntimeException {

    public EscalationStatusNotFoundException(String id) {
        super("EscalationStatus not found with id: " + id);
    }
}
