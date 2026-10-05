package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.dto.CityMunicipalityResponse;
import com.tarea.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class GetCityMunicipalityByIdUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public GetCityMunicipalityByIdUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public CityMunicipalityResponse execute(CityMunicipalityId id) {
        var cityMunicipality = cityMunicipalityRepository.findById(id)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id.value().toString()));
        return CityMunicipalityResponse.fromDomain(cityMunicipality);
    }
}
