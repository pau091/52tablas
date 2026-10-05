package com.tarea.domain.citymunicipality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CityMunicipalityRegisteredEvent(CityMunicipalityId id, LocalDateTime occurredOn) implements DomainEvent {

    public CityMunicipalityRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
