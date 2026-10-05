package com.tarea.domain.chatescalation.exception;

public class ChatEscalationNotFoundException extends RuntimeException {

    public ChatEscalationNotFoundException(String id) {
        super("ChatEscalation not found with id: " + id);
    }
}
