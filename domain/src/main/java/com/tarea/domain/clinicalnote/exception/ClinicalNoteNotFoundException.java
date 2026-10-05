package com.tarea.domain.clinicalnote.exception;

public class ClinicalNoteNotFoundException extends RuntimeException {

    public ClinicalNoteNotFoundException(String id) {
        super("ClinicalNote not found with id: " + id);
    }
}
