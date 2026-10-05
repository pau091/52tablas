package com.tarea.domain.chatmessage.exception;

public class ChatMessageNotFoundException extends RuntimeException {

    public ChatMessageNotFoundException(String id) {
        super("ChatMessage not found with id: " + id);
    }
}
