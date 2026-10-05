package com.tarea.domain.mentalstatusexam.exception;

public class MentalStatusExamNotFoundException extends RuntimeException {

    public MentalStatusExamNotFoundException(String id) {
        super("MentalStatusExam not found with id: " + id);
    }
}
