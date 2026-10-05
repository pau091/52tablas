package com.tarea.domain.encounter.model.aggregate;

import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.event.EncounterDeletedEvent;
import com.tarea.domain.encounter.event.EncounterRegisteredEvent;
import com.tarea.domain.encounter.event.EncounterUpdatedEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Encounter extends AggregateRoot {

    private final EncounterId id;
    private ClinicalRecordId clinicalRecordId;
    private ProfessionalId professionalId;
    private EncounterTypeId encounterTypeId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String reasonForVisit;
    private String currentCondition;
    private EncounterModalityId modalityId;
    private EncounterStatusId statusId;
    private final LocalDateTime createdAt;
    private final UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;

    private Encounter(
            EncounterId id,
            ClinicalRecordId clinicalRecordId,
            ProfessionalId professionalId,
            EncounterTypeId encounterTypeId,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            String reasonForVisit,
            String currentCondition,
            EncounterModalityId modalityId,
            EncounterStatusId statusId,
            LocalDateTime createdAt,
            UUID createdBy,
            LocalDateTime updatedAt,
            UUID updatedBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId, "clinicalRecordId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId, "encounterTypeId must not be null");
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId, "modalityId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static Encounter register(
            ClinicalRecordId clinicalRecordId,
            ProfessionalId professionalId,
            EncounterTypeId encounterTypeId,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            String reasonForVisit,
            String currentCondition,
            EncounterModalityId modalityId,
            EncounterStatusId statusId,
            UUID createdBy,
            UUID updatedBy) {
        EncounterId id = EncounterId.generate();
        Encounter encounter = new Encounter(
                id,
                clinicalRecordId,
                professionalId,
                encounterTypeId,
                startedAt,
                endedAt,
                reasonForVisit,
                currentCondition,
                modalityId,
                statusId,
                LocalDateTime.now(),
                createdBy,
                null,
                updatedBy);
        encounter.recordEvent(new EncounterRegisteredEvent(id, LocalDateTime.now()));
        return encounter;
    }

    public static Encounter restore(
            EncounterId id,
            ClinicalRecordId clinicalRecordId,
            ProfessionalId professionalId,
            EncounterTypeId encounterTypeId,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            String reasonForVisit,
            String currentCondition,
            EncounterModalityId modalityId,
            EncounterStatusId statusId,
            LocalDateTime createdAt,
            UUID createdBy,
            LocalDateTime updatedAt,
            UUID updatedBy) {
        return new Encounter(
                id,
                clinicalRecordId,
                professionalId,
                encounterTypeId,
                startedAt,
                endedAt,
                reasonForVisit,
                currentCondition,
                modalityId,
                statusId,
                createdAt,
                createdBy,
                updatedAt,
                updatedBy);
    }

    public void update(
            ClinicalRecordId clinicalRecordId,
            ProfessionalId professionalId,
            EncounterTypeId encounterTypeId,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            String reasonForVisit,
            String currentCondition,
            EncounterModalityId modalityId,
            EncounterStatusId statusId,
            UUID updatedBy) {
        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId, "clinicalRecordId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId, "encounterTypeId must not be null");
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId, "modalityId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EncounterUpdatedEvent(
                id,
                this.clinicalRecordId,
                this.professionalId,
                this.encounterTypeId,
                this.startedAt,
                this.endedAt,
                this.reasonForVisit,
                this.currentCondition,
                this.modalityId,
                this.statusId,
                this.updatedBy,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterDeletedEvent(id, LocalDateTime.now()));
    }

    public EncounterId id() {
        return id;
    }

    public ClinicalRecordId clinicalRecordId() {
        return clinicalRecordId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public EncounterTypeId encounterTypeId() {
        return encounterTypeId;
    }

    public LocalDateTime startedAt() {
        return startedAt;
    }

    public LocalDateTime endedAt() {
        return endedAt;
    }

    public String reasonForVisit() {
        return reasonForVisit;
    }

    public String currentCondition() {
        return currentCondition;
    }

    public EncounterModalityId modalityId() {
        return modalityId;
    }

    public EncounterStatusId statusId() {
        return statusId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public UUID createdBy() {
        return createdBy;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }

    public UUID updatedBy() {
        return updatedBy;
    }
}
