package com.tarea.domain.airunstatus.exception;

public class AiRunStatusNotFoundException extends RuntimeException {

    public AiRunStatusNotFoundException(String id) {
        super("AiRunStatus not found with id: " + id);
    }
}
