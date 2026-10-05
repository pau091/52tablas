package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.dto.CityMunicipalityResponse;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

import java.util.List;

public class ListCityMunicipalitiesUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public ListCityMunicipalitiesUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public List<CityMunicipalityResponse> execute() {
        return cityMunicipalityRepository.findAll().stream()
                .map(CityMunicipalityResponse::fromDomain)
                .toList();
    }
}
