package com.tarea.domain.treatmentplan.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.treatmentplan.event.TreatmentPlanDeletedEvent;
import com.tarea.domain.treatmentplan.event.TreatmentPlanRegisteredEvent;
import com.tarea.domain.treatmentplan.event.TreatmentPlanUpdatedEvent;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentPlan extends AggregateRoot {

    private final TreatmentPlanId id;
    private EncounterId encounterId;
    private ProfessionalId professionalId;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private TreatmentStatusId treatmentStatusId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentPlan(
            TreatmentPlanId id,
            EncounterId encounterId,
            ProfessionalId professionalId,
            String title,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            TreatmentStatusId treatmentStatusId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = Objects.requireNonNull(treatmentStatusId, "treatmentStatusId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static TreatmentPlan register(
            EncounterId encounterId,
            ProfessionalId professionalId,
            String title,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            TreatmentStatusId treatmentStatusId) {
        TreatmentPlanId id = TreatmentPlanId.generate();
        TreatmentPlan treatmentPlan = new TreatmentPlan(
                id,
                encounterId,
                professionalId,
                title,
                description,
                startDate,
                endDate,
                treatmentStatusId,
                LocalDateTime.now(),
                null);
        treatmentPlan.recordEvent(new TreatmentPlanRegisteredEvent(id, LocalDateTime.now()));
        return treatmentPlan;
    }

    public static TreatmentPlan restore(
            TreatmentPlanId id,
            EncounterId encounterId,
            ProfessionalId professionalId,
            String title,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            TreatmentStatusId treatmentStatusId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new TreatmentPlan(
                id,
                encounterId,
                professionalId,
                title,
                description,
                startDate,
                endDate,
                treatmentStatusId,
                createdAt,
                updatedAt);
    }

    public void update(
            EncounterId encounterId,
            ProfessionalId professionalId,
            String title,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            TreatmentStatusId treatmentStatusId) {
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = Objects.requireNonNull(treatmentStatusId, "treatmentStatusId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentPlanUpdatedEvent(
                id,
                this.encounterId,
                this.professionalId,
                this.title,
                this.description,
                this.startDate,
                this.endDate,
                this.treatmentStatusId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentPlanDeletedEvent(id, LocalDateTime.now()));
    }

    public TreatmentPlanId id() {
        return id;
    }

    public EncounterId encounterId() {
        return encounterId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public LocalDate startDate() {
        return startDate;
    }

    public LocalDate endDate() {
        return endDate;
    }

    public TreatmentStatusId treatmentStatusId() {
        return treatmentStatusId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
