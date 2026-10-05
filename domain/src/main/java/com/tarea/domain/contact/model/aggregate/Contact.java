package com.tarea.domain.contact.model.aggregate;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.contact.event.ContactDeletedEvent;
import com.tarea.domain.contact.event.ContactRegisteredEvent;
import com.tarea.domain.contact.event.ContactUpdatedEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Contact extends AggregateRoot {

    private final ContactId id;
    private String fullName;
    private String email;
    private String notes;
    private CityMunicipalityId cityId;
    private final LocalDateTime createdAt;
    private final ProfessionalId createdBy;
    private LocalDateTime updatedAt;
    private ProfessionalId updatedBy;

    private Contact(
            ContactId id,
            String fullName,
            String email,
            String notes,
            CityMunicipalityId cityId,
            LocalDateTime createdAt,
            ProfessionalId createdBy,
            LocalDateTime updatedAt,
            ProfessionalId updatedBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.createdBy = Objects.requireNonNull(createdBy, "createdBy must not be null");
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static Contact register(
            String fullName,
            String email,
            String notes,
            CityMunicipalityId cityId,
            ProfessionalId createdBy,
            ProfessionalId updatedBy) {
        ContactId id = ContactId.generate();
        Contact contact = new Contact(
                id,
                fullName,
                email,
                notes,
                cityId,
                LocalDateTime.now(),
                createdBy,
                null,
                updatedBy);
        contact.recordEvent(new ContactRegisteredEvent(id, LocalDateTime.now()));
        return contact;
    }

    public static Contact restore(
            ContactId id,
            String fullName,
            String email,
            String notes,
            CityMunicipalityId cityId,
            LocalDateTime createdAt,
            ProfessionalId createdBy,
            LocalDateTime updatedAt,
            ProfessionalId updatedBy) {
        return new Contact(
                id,
                fullName,
                email,
                notes,
                cityId,
                createdAt,
                createdBy,
                updatedAt,
                updatedBy);
    }

    public void update(
            String fullName,
            String email,
            String notes,
            CityMunicipalityId cityId,
            ProfessionalId updatedBy) {
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ContactUpdatedEvent(
                id,
                this.fullName,
                this.email,
                this.notes,
                this.cityId,
                this.updatedBy,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ContactDeletedEvent(id, LocalDateTime.now()));
    }

    public ContactId id() {
        return id;
    }

    public String fullName() {
        return fullName;
    }

    public String email() {
        return email;
    }

    public String notes() {
        return notes;
    }

    public CityMunicipalityId cityId() {
        return cityId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public ProfessionalId createdBy() {
        return createdBy;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }

    public ProfessionalId updatedBy() {
        return updatedBy;
    }
}
