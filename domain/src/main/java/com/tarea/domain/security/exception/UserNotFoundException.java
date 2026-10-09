package com.tarea.domain.security.exception;

public class UserNotFoundException extends SecurityDomainException {

    public UserNotFoundException(String message) {
        super(message);
    }
}