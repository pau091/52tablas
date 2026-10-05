package com.tarea.application.priority.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PriorityNotFoundApplicationException extends ApplicationException {

    public PriorityNotFoundApplicationException(String id) {
        super("Priority not found with id: " + id);
    }
}
