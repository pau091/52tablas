package com.tarea.domain.chatescalationassignment.exception;

public class ChatEscalationAssignmentNotFoundException extends RuntimeException {

    public ChatEscalationAssignmentNotFoundException(String id) {
        super("ChatEscalationAssignment not found with id: " + id);
    }
}
