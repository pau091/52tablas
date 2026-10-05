package com.tarea.domain.treatmentgoalstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusDeletedEvent;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusRegisteredEvent;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusUpdatedEvent;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentGoalStatus extends AggregateRoot {

    private final TreatmentGoalStatusId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoalStatus(
            TreatmentGoalStatusId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoalStatus register(String code, String name, Boolean active) {
        TreatmentGoalStatusId id = TreatmentGoalStatusId.generate();
        TreatmentGoalStatus treatmentGoalStatus = new TreatmentGoalStatus(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        treatmentGoalStatus.recordEvent(new TreatmentGoalStatusRegisteredEvent(id, LocalDateTime.now()));
        return treatmentGoalStatus;
    }

    public static TreatmentGoalStatus restore(
            TreatmentGoalStatusId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new TreatmentGoalStatus(
                id,
                code,
                name,
                active,
                createdAt,
                updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new TreatmentGoalStatusUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentGoalStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public TreatmentGoalStatusId id() {
        return id;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }

    public Boolean active() {
        return active;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
