package com.tarea.domain.assessmenttype.exception;

public class AssessmentTypeNotFoundException extends RuntimeException {

    public AssessmentTypeNotFoundException(String id) {
        super("AssessmentType not found with id: " + id);
    }
}
