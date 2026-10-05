package com.tarea.domain.phonecontact.exception;

public class PhoneContactNotFoundException extends RuntimeException {

    public PhoneContactNotFoundException(String id) {
        super("PhoneContact not found with id: " + id);
    }
}
