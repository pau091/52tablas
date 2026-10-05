package com.tarea.domain.risklevel.exception;

public class RiskLevelNotFoundException extends RuntimeException {

    public RiskLevelNotFoundException(String id) {
        super("RiskLevel not found with id: " + id);
    }
}
