package com.tarea.application.chatmessage.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatMessageNotFoundApplicationException extends ApplicationException {

    public ChatMessageNotFoundApplicationException(String id) {
        super("ChatMessage not found with id: " + id);
    }
}
