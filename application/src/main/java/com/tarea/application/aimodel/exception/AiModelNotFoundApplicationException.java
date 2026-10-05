package com.tarea.application.aimodel.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AiModelNotFoundApplicationException extends ApplicationException {

    public AiModelNotFoundApplicationException(String id) {
        super("AiModel not found with id: " + id);
    }
}
