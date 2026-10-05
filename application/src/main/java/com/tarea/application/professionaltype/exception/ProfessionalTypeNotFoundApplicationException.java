package com.tarea.application.professionaltype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ProfessionalTypeNotFoundApplicationException extends ApplicationException {

    public ProfessionalTypeNotFoundApplicationException(String id) {
        super("ProfessionalType not found with id: " + id);
    }
}
