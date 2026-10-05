package com.tarea.domain.patientallergy.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patientallergy.event.PatientAllergyDeletedEvent;
import com.tarea.domain.patientallergy.event.PatientAllergyRegisteredEvent;
import com.tarea.domain.patientallergy.event.PatientAllergyUpdatedEvent;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class PatientAllergy extends AggregateRoot {

    private final PatientAllergyId id;
    private PatientId patientId;
    private String substance;
    private String reaction;
    private String severity;
    private Boolean active;
    private LocalDateTime recordedAt;
    private UUID recordedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private PatientAllergy(
            PatientAllergyId id,
            PatientId patientId,
            String substance,
            String reaction,
            String severity,
            Boolean active,
            LocalDateTime recordedAt,
            UUID recordedBy,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static PatientAllergy register(
            PatientId patientId,
            String substance,
            String reaction,
            String severity,
            Boolean active,
            LocalDateTime recordedAt,
            UUID recordedBy) {
        PatientAllergyId id = PatientAllergyId.generate();
        PatientAllergy patientAllergy = new PatientAllergy(
                id,
                patientId,
                substance,
                reaction,
                severity,
                active != null ? active : Boolean.TRUE,
                recordedAt,
                recordedBy,
                LocalDateTime.now(),
                null);
        patientAllergy.recordEvent(new PatientAllergyRegisteredEvent(id, LocalDateTime.now()));
        return patientAllergy;
    }

    public static PatientAllergy restore(
            PatientAllergyId id,
            PatientId patientId,
            String substance,
            String reaction,
            String severity,
            Boolean active,
            LocalDateTime recordedAt,
            UUID recordedBy,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new PatientAllergy(
                id,
                patientId,
                substance,
                reaction,
                severity,
                active,
                recordedAt,
                recordedBy,
                createdAt,
                updatedAt);
    }

    public void update(
            PatientId patientId,
            String substance,
            String reaction,
            String severity,
            Boolean active,
            LocalDateTime recordedAt,
            UUID recordedBy) {
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PatientAllergyUpdatedEvent(
                id,
                this.patientId,
                this.substance,
                this.reaction,
                this.severity,
                this.active,
                this.recordedAt,
                this.recordedBy,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PatientAllergyDeletedEvent(id, LocalDateTime.now()));
    }

    public PatientAllergyId id() {
        return id;
    }

    public PatientId patientId() {
        return patientId;
    }

    public String substance() {
        return substance;
    }

    public String reaction() {
        return reaction;
    }

    public String severity() {
        return severity;
    }

    public Boolean active() {
        return active;
    }

    public LocalDateTime recordedAt() {
        return recordedAt;
    }

    public UUID recordedBy() {
        return recordedBy;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
