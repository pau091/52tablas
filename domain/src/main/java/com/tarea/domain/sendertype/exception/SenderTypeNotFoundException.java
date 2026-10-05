package com.tarea.domain.sendertype.exception;

public class SenderTypeNotFoundException extends RuntimeException {

    public SenderTypeNotFoundException(String id) {
        super("SenderType not found with id: " + id);
    }
}
