package com.tarea.domain.relationshiptype.exception;

public class RelationshipTypeNotFoundException extends RuntimeException {

    public RelationshipTypeNotFoundException(String id) {
        super("RelationshipType not found with id: " + id);
    }
}
