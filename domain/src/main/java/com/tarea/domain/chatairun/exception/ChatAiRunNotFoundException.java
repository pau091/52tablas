package com.tarea.domain.chatairun.exception;

public class ChatAiRunNotFoundException extends RuntimeException {

    public ChatAiRunNotFoundException(String id) {
        super("ChatAiRun not found with id: " + id);
    }
}
