package com.tarea.domain.gender.exception;

public class GenderNotFoundException extends RuntimeException {

    public GenderNotFoundException(String id) {
        super("Gender not found with id: " + id);
    }
}
