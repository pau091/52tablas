package com.tarea.domain.priority.exception;

public class PriorityNotFoundException extends RuntimeException {

    public PriorityNotFoundException(String id) {
        super("Priority not found with id: " + id);
    }
}
