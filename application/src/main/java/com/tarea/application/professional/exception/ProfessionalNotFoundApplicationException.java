package com.tarea.application.professional.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ProfessionalNotFoundApplicationException extends ApplicationException {

    public ProfessionalNotFoundApplicationException(String id) {
        super("Professional not found with id: " + id);
    }
}
