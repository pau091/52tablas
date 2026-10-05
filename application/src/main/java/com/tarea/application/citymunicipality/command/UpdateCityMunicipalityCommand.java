package com.tarea.application.citymunicipality.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

public record UpdateCityMunicipalityCommand(
        CityMunicipalityId id,
        String nameCity,
        String codeCity,
        String description,
        Boolean isActive,
        StateRegionId regionId
) {
}
