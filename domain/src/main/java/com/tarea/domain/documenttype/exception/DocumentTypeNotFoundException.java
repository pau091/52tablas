package com.tarea.domain.documenttype.exception;

public class DocumentTypeNotFoundException extends RuntimeException {

    public DocumentTypeNotFoundException(String id) {
        super("DocumentType not found with id: " + id);
    }
}
