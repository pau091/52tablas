package com.tarea.domain.citymunicipality.event;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CityMunicipalityUpdatedEvent(
        CityMunicipalityId id,
        String nameCity,
        String codeCity,
        String description,
        Boolean isActive,
        StateRegionId regionId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public CityMunicipalityUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
