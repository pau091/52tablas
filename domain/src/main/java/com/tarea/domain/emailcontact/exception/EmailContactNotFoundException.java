package com.tarea.domain.emailcontact.exception;

public class EmailContactNotFoundException extends RuntimeException {

    public EmailContactNotFoundException(String id) {
        super("EmailContact not found with id: " + id);
    }
}
