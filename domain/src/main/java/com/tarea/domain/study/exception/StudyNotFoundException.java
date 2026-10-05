package com.tarea.domain.study.exception;

public class StudyNotFoundException extends RuntimeException {

    public StudyNotFoundException(String id) {
        super("Study not found with id: " + id);
    }
}
