package com.tarea.domain.aimodel.exception;

public class AiModelNotFoundException extends RuntimeException {

    public AiModelNotFoundException(String id) {
        super("AiModel not found with id: " + id);
    }
}
