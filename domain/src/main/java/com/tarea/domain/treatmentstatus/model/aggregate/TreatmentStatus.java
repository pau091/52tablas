package com.tarea.domain.treatmentstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusDeletedEvent;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusRegisteredEvent;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusUpdatedEvent;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentStatus extends AggregateRoot {

    private final TreatmentStatusId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentStatus(
            TreatmentStatusId id,
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

    public static TreatmentStatus register(String code, String name, Boolean active) {
        TreatmentStatusId id = TreatmentStatusId.generate();
        TreatmentStatus treatmentStatus = new TreatmentStatus(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        treatmentStatus.recordEvent(new TreatmentStatusRegisteredEvent(id, LocalDateTime.now()));
        return treatmentStatus;
    }

    public static TreatmentStatus restore(
            TreatmentStatusId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new TreatmentStatus(
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
        recordEvent(new TreatmentStatusUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public TreatmentStatusId id() {
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
