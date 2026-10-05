package com.tarea.domain.contact.exception;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(String id) {
        super("Contact not found with id: " + id);
    }
}
