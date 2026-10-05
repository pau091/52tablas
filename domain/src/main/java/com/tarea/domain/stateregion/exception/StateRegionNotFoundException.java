package com.tarea.domain.stateregion.exception;

public class StateRegionNotFoundException extends RuntimeException {

    public StateRegionNotFoundException(String id) {
        super("StateRegion not found with id: " + id);
    }
}
