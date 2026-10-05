package com.tarea.application.clinicalrecord.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ClinicalRecordNotFoundApplicationException extends ApplicationException {

    public ClinicalRecordNotFoundApplicationException(String id) {
        super("ClinicalRecord not found with id: " + id);
    }
}
