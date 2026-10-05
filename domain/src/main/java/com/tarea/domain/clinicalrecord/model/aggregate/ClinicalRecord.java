package com.tarea.domain.clinicalrecord.model.aggregate;

import com.tarea.domain.clinicalrecord.event.ClinicalRecordDeletedEvent;
import com.tarea.domain.clinicalrecord.event.ClinicalRecordRegisteredEvent;
import com.tarea.domain.clinicalrecord.event.ClinicalRecordUpdatedEvent;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalRecord extends AggregateRoot {

    private final ClinicalRecordId id;
    private PatientId patientId;
    private LocalDateTime creationDate;
    private String recordNumber;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private ClinicalRecordStatusId statusId;
    private final LocalDateTime createdAt;
    private final ProfessionalId createdBy;

    private ClinicalRecord(
            ClinicalRecordId id,
            PatientId patientId,
            LocalDateTime creationDate,
            String recordNumber,
            LocalDateTime openedAt,
            LocalDateTime closedAt,
            ClinicalRecordStatusId statusId,
            LocalDateTime createdAt,
            ProfessionalId createdBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.createdBy = Objects.requireNonNull(createdBy, "createdBy must not be null");
    }

    public static ClinicalRecord register(
            PatientId patientId,
            LocalDateTime creationDate,
            String recordNumber,
            LocalDateTime openedAt,
            LocalDateTime closedAt,
            ClinicalRecordStatusId statusId,
            ProfessionalId createdBy) {
        ClinicalRecordId id = ClinicalRecordId.generate();
        ClinicalRecord clinicalRecord = new ClinicalRecord(
                id,
                patientId,
                creationDate,
                recordNumber,
                openedAt,
                closedAt,
                statusId,
                LocalDateTime.now(),
                createdBy);
        clinicalRecord.recordEvent(new ClinicalRecordRegisteredEvent(id, LocalDateTime.now()));
        return clinicalRecord;
    }

    public static ClinicalRecord restore(
            ClinicalRecordId id,
            PatientId patientId,
            LocalDateTime creationDate,
            String recordNumber,
            LocalDateTime openedAt,
            LocalDateTime closedAt,
            ClinicalRecordStatusId statusId,
            LocalDateTime createdAt,
            ProfessionalId createdBy) {
        return new ClinicalRecord(
                id,
                patientId,
                creationDate,
                recordNumber,
                openedAt,
                closedAt,
                statusId,
                createdAt,
                createdBy);
    }

    public void update(
            PatientId patientId,
            LocalDateTime creationDate,
            String recordNumber,
            LocalDateTime openedAt,
            LocalDateTime closedAt,
            ClinicalRecordStatusId statusId) {
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        recordEvent(new ClinicalRecordUpdatedEvent(
                id,
                this.patientId,
                this.creationDate,
                this.recordNumber,
                this.openedAt,
                this.closedAt,
                this.statusId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalRecordDeletedEvent(id, LocalDateTime.now()));
    }

    public ClinicalRecordId id() {
        return id;
    }

    public PatientId patientId() {
        return patientId;
    }

    public LocalDateTime creationDate() {
        return creationDate;
    }

    public String recordNumber() {
        return recordNumber;
    }

    public LocalDateTime openedAt() {
        return openedAt;
    }

    public LocalDateTime closedAt() {
        return closedAt;
    }

    public ClinicalRecordStatusId statusId() {
        return statusId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public ProfessionalId createdBy() {
        return createdBy;
    }
}
