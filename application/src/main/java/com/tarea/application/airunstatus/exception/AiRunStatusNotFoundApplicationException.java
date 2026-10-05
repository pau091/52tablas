package com.tarea.application.airunstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AiRunStatusNotFoundApplicationException extends ApplicationException {

    public AiRunStatusNotFoundApplicationException(String id) {
        super("AiRunStatus not found with id: " + id);
    }
}
