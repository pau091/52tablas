package com.tarea.domain.citymunicipality.exception;

public class CityMunicipalityNotFoundException extends RuntimeException {

    public CityMunicipalityNotFoundException(String id) {
        super("CityMunicipality not found with id: " + id);
    }
}
