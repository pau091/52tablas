package com.tarea.application.consenttype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ConsentTypeNotFoundApplicationException extends ApplicationException {

    public ConsentTypeNotFoundApplicationException(String id) {
        super("ConsentType not found with id: " + id);
    }
}
