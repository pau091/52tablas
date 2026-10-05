package com.tarea.application.citymunicipality.dto;

import com.tarea.domain.citymunicipality.model.aggregate.CityMunicipality;

import java.time.LocalDateTime;
import java.util.UUID;

public record CityMunicipalityResponse(
        UUID id,
        String nameCity,
        String codeCity,
        String description,
        Boolean isActive,
        UUID regionId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static CityMunicipalityResponse fromDomain(CityMunicipality cityMunicipality) {
        return new CityMunicipalityResponse(
                cityMunicipality.id().value(),
                cityMunicipality.nameCity(),
                cityMunicipality.codeCity(),
                cityMunicipality.description(),
                cityMunicipality.isActive(),
                cityMunicipality.regionId().value(),
                cityMunicipality.createdAt(),
                cityMunicipality.updatedAt()
        );
    }
}
