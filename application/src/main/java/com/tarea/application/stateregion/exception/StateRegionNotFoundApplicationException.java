package com.tarea.application.stateregion.exception;

import com.tarea.application.common.exception.ApplicationException;

public class StateRegionNotFoundApplicationException extends ApplicationException {

    public StateRegionNotFoundApplicationException(String id) {
        super("StateRegion not found with id: " + id);
    }
}
