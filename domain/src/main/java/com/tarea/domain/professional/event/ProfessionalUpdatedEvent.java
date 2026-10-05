package com.tarea.domain.professional.event;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalUpdatedEvent(
        ProfessionalId id,
        DocumentTypeId documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        ProfessionalTypeId professionalType,
        String licenseNumber,
        Boolean active,
        CityMunicipalityId cityId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ProfessionalUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
