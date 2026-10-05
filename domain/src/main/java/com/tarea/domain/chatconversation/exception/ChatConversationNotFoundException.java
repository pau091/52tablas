package com.tarea.domain.chatconversation.exception;

public class ChatConversationNotFoundException extends RuntimeException {

    public ChatConversationNotFoundException(String id) {
        super("ChatConversation not found with id: " + id);
    }
}
