package com.tarea.application.study.exception;

import com.tarea.application.common.exception.ApplicationException;

public class StudyNotFoundApplicationException extends ApplicationException {

    public StudyNotFoundApplicationException(String id) {
        super("Study not found with id: " + id);
    }
}
