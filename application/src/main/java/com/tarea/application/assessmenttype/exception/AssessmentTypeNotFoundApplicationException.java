package com.tarea.application.assessmenttype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AssessmentTypeNotFoundApplicationException extends ApplicationException {

    public AssessmentTypeNotFoundApplicationException(String id) {
        super("AssessmentType not found with id: " + id);
    }
}
