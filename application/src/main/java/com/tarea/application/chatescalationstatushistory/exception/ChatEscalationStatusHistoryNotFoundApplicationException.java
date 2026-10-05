package com.tarea.application.chatescalationstatushistory.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatEscalationStatusHistoryNotFoundApplicationException extends ApplicationException {

    public ChatEscalationStatusHistoryNotFoundApplicationException(String id) {
        super("ChatEscalationStatusHistory not found with id: " + id);
    }
}
