package com.tarea.domain.professionalstudy.exception;

public class ProfessionalStudyNotFoundException extends RuntimeException {

    public ProfessionalStudyNotFoundException(String id) {
        super("ProfessionalStudy not found with id: " + id);
    }
}
