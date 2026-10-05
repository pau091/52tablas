package com.tarea.domain.patientcontact.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patientcontact.event.PatientContactDeletedEvent;
import com.tarea.domain.patientcontact.event.PatientContactRegisteredEvent;
import com.tarea.domain.patientcontact.event.PatientContactUpdatedEvent;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class PatientContact extends AggregateRoot {

    private final PatientContactId id;
    private ContactId contactId;
    private PatientId patientId;
    private Boolean isPrimaryContact;
    private Boolean isEmergencyContact;
    private RelationshipTypeId relationshipTypeId;

    private PatientContact(
            PatientContactId id,
            ContactId contactId,
            PatientId patientId,
            Boolean isPrimaryContact,
            Boolean isEmergencyContact,
            RelationshipTypeId relationshipTypeId) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = Objects.requireNonNull(relationshipTypeId, "relationshipTypeId must not be null");
    }

    public static PatientContact register(
            ContactId contactId,
            PatientId patientId,
            Boolean isPrimaryContact,
            Boolean isEmergencyContact,
            RelationshipTypeId relationshipTypeId) {
        PatientContactId id = PatientContactId.generate();
        PatientContact patientContact = new PatientContact(
                id,
                contactId,
                patientId,
                isPrimaryContact != null ? isPrimaryContact : Boolean.FALSE,
                isEmergencyContact != null ? isEmergencyContact : Boolean.FALSE,
                relationshipTypeId);
        patientContact.recordEvent(new PatientContactRegisteredEvent(id, LocalDateTime.now()));
        return patientContact;
    }

    public static PatientContact restore(
            PatientContactId id,
            ContactId contactId,
            PatientId patientId,
            Boolean isPrimaryContact,
            Boolean isEmergencyContact,
            RelationshipTypeId relationshipTypeId) {
        return new PatientContact(
                id,
                contactId,
                patientId,
                isPrimaryContact,
                isEmergencyContact,
                relationshipTypeId);
    }

    public void update(
            ContactId contactId,
            PatientId patientId,
            Boolean isPrimaryContact,
            Boolean isEmergencyContact,
            RelationshipTypeId relationshipTypeId) {
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = Objects.requireNonNull(relationshipTypeId, "relationshipTypeId must not be null");
        recordEvent(new PatientContactUpdatedEvent(
                id,
                this.contactId,
                this.patientId,
                this.isPrimaryContact,
                this.isEmergencyContact,
                this.relationshipTypeId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PatientContactDeletedEvent(id, LocalDateTime.now()));
    }

    public PatientContactId id() {
        return id;
    }

    public ContactId contactId() {
        return contactId;
    }

    public PatientId patientId() {
        return patientId;
    }

    public Boolean isPrimaryContact() {
        return isPrimaryContact;
    }

    public Boolean isEmergencyContact() {
        return isEmergencyContact;
    }

    public RelationshipTypeId relationshipTypeId() {
        return relationshipTypeId;
    }
}
