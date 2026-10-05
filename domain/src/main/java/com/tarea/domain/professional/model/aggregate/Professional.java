package com.tarea.domain.professional.model.aggregate;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professional.event.ProfessionalDeletedEvent;
import com.tarea.domain.professional.event.ProfessionalRegisteredEvent;
import com.tarea.domain.professional.event.ProfessionalUpdatedEvent;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Professional extends AggregateRoot {

    private final ProfessionalId id;
    private DocumentTypeId documentTypeId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private ProfessionalTypeId professionalType;
    private String licenseNumber;
    private Boolean active;
    private CityMunicipalityId cityId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Professional(
            ProfessionalId id,
            DocumentTypeId documentTypeId,
            String documentNumber,
            String firstName,
            String lastName,
            ProfessionalTypeId professionalType,
            String licenseNumber,
            Boolean active,
            CityMunicipalityId cityId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalType = Objects.requireNonNull(professionalType, "professionalType must not be null");
        this.licenseNumber = Objects.requireNonNull(licenseNumber, "licenseNumber must not be null");
        this.active = active;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static Professional register(
            DocumentTypeId documentTypeId,
            String documentNumber,
            String firstName,
            String lastName,
            ProfessionalTypeId professionalType,
            String licenseNumber,
            Boolean active,
            CityMunicipalityId cityId) {
        ProfessionalId id = ProfessionalId.generate();
        Professional professional = new Professional(
                id,
                documentTypeId,
                documentNumber,
                firstName,
                lastName,
                professionalType,
                licenseNumber,
                active != null ? active : Boolean.TRUE,
                cityId,
                LocalDateTime.now(),
                null);
        professional.recordEvent(new ProfessionalRegisteredEvent(id, LocalDateTime.now()));
        return professional;
    }

    public static Professional restore(
            ProfessionalId id,
            DocumentTypeId documentTypeId,
            String documentNumber,
            String firstName,
            String lastName,
            ProfessionalTypeId professionalType,
            String licenseNumber,
            Boolean active,
            CityMunicipalityId cityId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new Professional(
                id,
                documentTypeId,
                documentNumber,
                firstName,
                lastName,
                professionalType,
                licenseNumber,
                active,
                cityId,
                createdAt,
                updatedAt);
    }

    public void update(
            DocumentTypeId documentTypeId,
            String documentNumber,
            String firstName,
            String lastName,
            ProfessionalTypeId professionalType,
            String licenseNumber,
            Boolean active,
            CityMunicipalityId cityId) {
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalType = Objects.requireNonNull(professionalType, "professionalType must not be null");
        this.licenseNumber = Objects.requireNonNull(licenseNumber, "licenseNumber must not be null");
        this.active = active;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProfessionalUpdatedEvent(
                id,
                this.documentTypeId,
                this.documentNumber,
                this.firstName,
                this.lastName,
                this.professionalType,
                this.licenseNumber,
                this.active,
                this.cityId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalDeletedEvent(id, LocalDateTime.now()));
    }

    public ProfessionalId id() {
        return id;
    }

    public DocumentTypeId documentTypeId() {
        return documentTypeId;
    }

    public String documentNumber() {
        return documentNumber;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public ProfessionalTypeId professionalType() {
        return professionalType;
    }

    public String licenseNumber() {
        return licenseNumber;
    }

    public Boolean active() {
        return active;
    }

    public CityMunicipalityId cityId() {
        return cityId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
