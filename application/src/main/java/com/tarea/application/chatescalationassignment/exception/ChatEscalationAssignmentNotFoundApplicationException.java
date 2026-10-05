package com.tarea.application.chatescalationassignment.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatEscalationAssignmentNotFoundApplicationException extends ApplicationException {

    public ChatEscalationAssignmentNotFoundApplicationException(String id) {
        super("ChatEscalationAssignment not found with id: " + id);
    }
}
