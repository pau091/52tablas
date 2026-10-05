package com.tarea.application.sendertype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class SenderTypeNotFoundApplicationException extends ApplicationException {

    public SenderTypeNotFoundApplicationException(String id) {
        super("SenderType not found with id: " + id);
    }
}
