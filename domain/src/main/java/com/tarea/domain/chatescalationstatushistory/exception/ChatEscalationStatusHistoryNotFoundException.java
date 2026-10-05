package com.tarea.domain.chatescalationstatushistory.exception;

public class ChatEscalationStatusHistoryNotFoundException extends RuntimeException {

    public ChatEscalationStatusHistoryNotFoundException(String id) {
        super("ChatEscalationStatusHistory not found with id: " + id);
    }
}
