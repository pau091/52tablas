package com.tarea.application.citymunicipality.exception;

import com.tarea.application.common.exception.ApplicationException;

public class CityMunicipalityNotFoundApplicationException extends ApplicationException {

    public CityMunicipalityNotFoundApplicationException(String id) {
        super("CityMunicipality not found with id: " + id);
    }
}
