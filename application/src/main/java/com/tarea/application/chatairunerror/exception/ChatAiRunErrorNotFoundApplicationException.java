package com.tarea.application.chatairunerror.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunErrorNotFoundApplicationException extends ApplicationException {

    public ChatAiRunErrorNotFoundApplicationException(String id) {
        super("ChatAiRunError not found with id: " + id);
    }
}
