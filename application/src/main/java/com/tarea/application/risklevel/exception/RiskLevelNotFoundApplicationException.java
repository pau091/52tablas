package com.tarea.application.risklevel.exception;

import com.tarea.application.common.exception.ApplicationException;

public class RiskLevelNotFoundApplicationException extends ApplicationException {

    public RiskLevelNotFoundApplicationException(String id) {
        super("RiskLevel not found with id: " + id);
    }
}
