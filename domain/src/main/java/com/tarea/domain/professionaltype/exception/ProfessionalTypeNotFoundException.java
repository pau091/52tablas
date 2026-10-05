package com.tarea.domain.professionaltype.exception;

public class ProfessionalTypeNotFoundException extends RuntimeException {

    public ProfessionalTypeNotFoundException(String id) {
        super("ProfessionalType not found with id: " + id);
    }
}
