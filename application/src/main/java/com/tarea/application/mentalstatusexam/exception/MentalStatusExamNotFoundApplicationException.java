package com.tarea.application.mentalstatusexam.exception;

import com.tarea.application.common.exception.ApplicationException;

public class MentalStatusExamNotFoundApplicationException extends ApplicationException {

    public MentalStatusExamNotFoundApplicationException(String id) {
        super("MentalStatusExam not found with id: " + id);
    }
}
