package com.tarea.application.patientcontact.dto;

import com.tarea.domain.patientcontact.model.aggregate.PatientContact;

import java.util.UUID;

public record PatientContactResponse(
        UUID id,
        UUID contactId,
        UUID patientId,
        Boolean isPrimaryContact,
        Boolean isEmergencyContact,
        UUID relationshipTypeId
) {

    public static PatientContactResponse fromDomain(PatientContact patientContact) {
        return new PatientContactResponse(
                patientContact.id().value(),
                patientContact.contactId().value(),
                patientContact.patientId().value(),
                patientContact.isPrimaryContact(),
                patientContact.isEmergencyContact(),
                patientContact.relationshipTypeId().value()
        );
    }
}
