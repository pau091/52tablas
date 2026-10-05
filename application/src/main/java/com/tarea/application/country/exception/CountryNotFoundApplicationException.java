package com.tarea.application.country.exception;

import com.tarea.application.common.exception.ApplicationException;

public class CountryNotFoundApplicationException extends ApplicationException {

    public CountryNotFoundApplicationException(String id) {
        super("Country not found with id: " + id);
    }
}
