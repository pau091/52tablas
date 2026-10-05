package com.tarea.domain.patientcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientContactUpdatedEvent(
        PatientContactId id,
        ContactId contactId,
        PatientId patientId,
        Boolean isPrimaryContact,
        Boolean isEmergencyContact,
        RelationshipTypeId relationshipTypeId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public PatientContactUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
