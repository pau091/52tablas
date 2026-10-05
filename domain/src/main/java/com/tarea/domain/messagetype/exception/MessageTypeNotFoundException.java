package com.tarea.domain.messagetype.exception;

public class MessageTypeNotFoundException extends RuntimeException {

    public MessageTypeNotFoundException(String id) {
        super("MessageType not found with id: " + id);
    }
}
