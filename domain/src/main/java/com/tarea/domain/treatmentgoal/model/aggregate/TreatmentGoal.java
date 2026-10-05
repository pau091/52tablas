package com.tarea.domain.treatmentgoal.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalDeletedEvent;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalRegisteredEvent;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalUpdatedEvent;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentGoal extends AggregateRoot {

    private final TreatmentGoalId id;
    private TreatmentPlanId treatmentPlanId;
    private String description;
    private LocalDate targetDate;
    private LocalDateTime completedAt;
    private String notes;
    private TreatmentGoalStatusId treatmentGoalId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoal(
            TreatmentGoalId id,
            TreatmentPlanId treatmentPlanId,
            String description,
            LocalDate targetDate,
            LocalDateTime completedAt,
            String notes,
            TreatmentGoalStatusId treatmentGoalId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalId = Objects.requireNonNull(treatmentGoalId, "treatmentGoalId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoal register(
            TreatmentPlanId treatmentPlanId,
            String description,
            LocalDate targetDate,
            LocalDateTime completedAt,
            String notes,
            TreatmentGoalStatusId treatmentGoalId) {
        TreatmentGoalId id = TreatmentGoalId.generate();
        TreatmentGoal treatmentGoal = new TreatmentGoal(
                id,
                treatmentPlanId,
                description,
                targetDate,
                completedAt,
                notes,
                treatmentGoalId,
                LocalDateTime.now(),
                null);
        treatmentGoal.recordEvent(new TreatmentGoalRegisteredEvent(id, LocalDateTime.now()));
        return treatmentGoal;
    }

    public static TreatmentGoal restore(
            TreatmentGoalId id,
            TreatmentPlanId treatmentPlanId,
            String description,
            LocalDate targetDate,
            LocalDateTime completedAt,
            String notes,
            TreatmentGoalStatusId treatmentGoalId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new TreatmentGoal(
                id,
                treatmentPlanId,
                description,
                targetDate,
                completedAt,
                notes,
                treatmentGoalId,
                createdAt,
                updatedAt);
    }

    public void update(
            TreatmentPlanId treatmentPlanId,
            String description,
            LocalDate targetDate,
            LocalDateTime completedAt,
            String notes,
            TreatmentGoalStatusId treatmentGoalId) {
        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalId = Objects.requireNonNull(treatmentGoalId, "treatmentGoalId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentGoalUpdatedEvent(
                id,
                this.treatmentPlanId,
                this.description,
                this.targetDate,
                this.completedAt,
                this.notes,
                this.treatmentGoalId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentGoalDeletedEvent(id, LocalDateTime.now()));
    }

    public TreatmentGoalId id() {
        return id;
    }

    public TreatmentPlanId treatmentPlanId() {
        return treatmentPlanId;
    }

    public String description() {
        return description;
    }

    public LocalDate targetDate() {
        return targetDate;
    }

    public LocalDateTime completedAt() {
        return completedAt;
    }

    public String notes() {
        return notes;
    }

    public TreatmentGoalStatusId treatmentGoalId() {
        return treatmentGoalId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
