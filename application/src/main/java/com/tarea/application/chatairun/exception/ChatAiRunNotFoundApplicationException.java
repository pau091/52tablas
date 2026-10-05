package com.tarea.application.chatairun.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunNotFoundApplicationException extends ApplicationException {

    public ChatAiRunNotFoundApplicationException(String id) {
        super("ChatAiRun not found with id: " + id);
    }
}
