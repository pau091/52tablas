package com.tarea.domain.country.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String id) {
        super("Country not found with id: " + id);
    }
}
