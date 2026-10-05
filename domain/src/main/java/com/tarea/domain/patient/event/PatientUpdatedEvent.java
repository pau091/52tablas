package com.tarea.domain.patient.event;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record PatientUpdatedEvent(
        PatientId id,
        DocumentTypeId documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        LocalDate birthDate,
        GenderId biologicalSexId,
        GenderId genderIdentity,
        String email,
        String phone,
        String address,
        Boolean active,
        ProfessionalId updatedBy,
        CityMunicipalityId cityId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public PatientUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
