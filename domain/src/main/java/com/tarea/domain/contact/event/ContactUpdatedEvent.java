package com.tarea.domain.contact.event;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ContactUpdatedEvent(
        ContactId id,
        String fullName,
        String email,
        String notes,
        CityMunicipalityId cityId,
        ProfessionalId updatedBy,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ContactUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
