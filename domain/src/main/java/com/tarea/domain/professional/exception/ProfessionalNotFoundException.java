package com.tarea.domain.professional.exception;

public class ProfessionalNotFoundException extends RuntimeException {

    public ProfessionalNotFoundException(String id) {
        super("Professional not found with id: " + id);
    }
}
