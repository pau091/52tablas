package com.tarea.application.messagetype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class MessageTypeNotFoundApplicationException extends ApplicationException {

    public MessageTypeNotFoundApplicationException(String id) {
        super("MessageType not found with id: " + id);
    }
}
