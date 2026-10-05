package com.tarea.domain.stateregion.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StateRegionUpdatedEvent(
        StateRegionId id,
        String nameRegion,
        String codeRegion,
        String description,
        Boolean isActive,
        CountryId countryId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public StateRegionUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
