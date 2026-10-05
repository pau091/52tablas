package com.tarea.domain.chatairunerror.exception;

public class ChatAiRunErrorNotFoundException extends RuntimeException {

    public ChatAiRunErrorNotFoundException(String id) {
        super("ChatAiRunError not found with id: " + id);
    }
}
