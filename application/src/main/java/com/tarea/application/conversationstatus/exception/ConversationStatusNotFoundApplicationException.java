package com.tarea.application.conversationstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ConversationStatusNotFoundApplicationException extends ApplicationException {

    public ConversationStatusNotFoundApplicationException(String id) {
        super("ConversationStatus not found with id: " + id);
    }
}
