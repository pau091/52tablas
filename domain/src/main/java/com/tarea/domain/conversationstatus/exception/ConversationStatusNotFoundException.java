package com.tarea.domain.conversationstatus.exception;

public class ConversationStatusNotFoundException extends RuntimeException {

    public ConversationStatusNotFoundException(String id) {
        super("ConversationStatus not found with id: " + id);
    }
}
