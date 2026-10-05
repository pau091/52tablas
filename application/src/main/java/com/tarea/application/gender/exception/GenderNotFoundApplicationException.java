package com.tarea.application.gender.exception;

import com.tarea.application.common.exception.ApplicationException;

public class GenderNotFoundApplicationException extends ApplicationException {

    public GenderNotFoundApplicationException(String id) {
        super("Gender not found with id: " + id);
    }
}
