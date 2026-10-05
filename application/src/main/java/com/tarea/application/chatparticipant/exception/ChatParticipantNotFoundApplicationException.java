package com.tarea.application.chatparticipant.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatParticipantNotFoundApplicationException extends ApplicationException {

    public ChatParticipantNotFoundApplicationException(String id) {
        super("ChatParticipant not found with id: " + id);
    }
}
