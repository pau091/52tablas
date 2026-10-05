package com.tarea.domain.patient.model.aggregate;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.patient.event.PatientDeletedEvent;
import com.tarea.domain.patient.event.PatientRegisteredEvent;
import com.tarea.domain.patient.event.PatientUpdatedEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Patient extends AggregateRoot {

    private final PatientId id;
    private DocumentTypeId documentTypeId;
    private String documentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private LocalDate birthDate;
    private GenderId biologicalSexId;
    private GenderId genderIdentity;
    private String email;
    private String phone;
    private String address;
    private Boolean active;
    private final LocalDateTime createdAt;
    private final ProfessionalId createdBy;
    private LocalDateTime updatedAt;
    private ProfessionalId updatedBy;
    private CityMunicipalityId cityId;

    private Patient(
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
            LocalDateTime createdAt,
            ProfessionalId createdBy,
            LocalDateTime updatedAt,
            ProfessionalId updatedBy,
            CityMunicipalityId cityId) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId, "biologicalSexId must not be null");
        this.genderIdentity = Objects.requireNonNull(genderIdentity, "genderIdentity must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
    }

    public static Patient register(
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
            ProfessionalId createdBy,
            ProfessionalId updatedBy,
            CityMunicipalityId cityId) {
        PatientId id = PatientId.generate();
        Patient patient = new Patient(
                id,
                documentTypeId,
                documentNumber,
                firstName,
                middleName,
                lastName,
                secondLastName,
                birthDate,
                biologicalSexId,
                genderIdentity,
                email,
                phone,
                address,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                createdBy,
                null,
                updatedBy,
                cityId);
        patient.recordEvent(new PatientRegisteredEvent(id, LocalDateTime.now()));
        return patient;
    }

    public static Patient restore(
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
            LocalDateTime createdAt,
            ProfessionalId createdBy,
            LocalDateTime updatedAt,
            ProfessionalId updatedBy,
            CityMunicipalityId cityId) {
        return new Patient(
                id,
                documentTypeId,
                documentNumber,
                firstName,
                middleName,
                lastName,
                secondLastName,
                birthDate,
                biologicalSexId,
                genderIdentity,
                email,
                phone,
                address,
                active,
                createdAt,
                createdBy,
                updatedAt,
                updatedBy,
                cityId);
    }

    public void update(
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
            CityMunicipalityId cityId) {
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId, "biologicalSexId must not be null");
        this.genderIdentity = Objects.requireNonNull(genderIdentity, "genderIdentity must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.updatedBy = updatedBy;
        this.cityId = Objects.requireNonNull(cityId, "cityId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PatientUpdatedEvent(
                id,
                this.documentTypeId,
                this.documentNumber,
                this.firstName,
                this.middleName,
                this.lastName,
                this.secondLastName,
                this.birthDate,
                this.biologicalSexId,
                this.genderIdentity,
                this.email,
                this.phone,
                this.address,
                this.active,
                this.updatedBy,
                this.cityId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PatientDeletedEvent(id, LocalDateTime.now()));
    }

    public PatientId id() {
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

    public String middleName() {
        return middleName;
    }

    public String lastName() {
        return lastName;
    }

    public String secondLastName() {
        return secondLastName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public GenderId biologicalSexId() {
        return biologicalSexId;
    }

    public GenderId genderIdentity() {
        return genderIdentity;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public String address() {
        return address;
    }

    public Boolean active() {
        return active;
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

    public CityMunicipalityId cityId() {
        return cityId;
    }
}
