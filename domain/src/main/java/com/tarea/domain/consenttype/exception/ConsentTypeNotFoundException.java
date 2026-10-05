package com.tarea.domain.consenttype.exception;

public class ConsentTypeNotFoundException extends RuntimeException {

    public ConsentTypeNotFoundException(String id) {
        super("ConsentType not found with id: " + id);
    }
}
