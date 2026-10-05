package com.tarea.application.contact.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

public record UpdateContactCommand(
        ContactId id,
        String fullName,
        String email,
        String notes,
        CityMunicipalityId cityId,
        ProfessionalId updatedBy
) {
}
