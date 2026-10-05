package com.tarea.domain.encounterstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounterstatus.event.EncounterStatusDeletedEvent;
import com.tarea.domain.encounterstatus.event.EncounterStatusRegisteredEvent;
import com.tarea.domain.encounterstatus.event.EncounterStatusUpdatedEvent;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterStatus extends AggregateRoot {

    private final EncounterStatusId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterStatus(
            EncounterStatusId id,
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

    public static EncounterStatus register(String code, String name, Boolean active) {
        EncounterStatusId id = EncounterStatusId.generate();
        EncounterStatus encounterStatus = new EncounterStatus(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        encounterStatus.recordEvent(new EncounterStatusRegisteredEvent(id, LocalDateTime.now()));
        return encounterStatus;
    }

    public static EncounterStatus restore(
            EncounterStatusId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new EncounterStatus(
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
        recordEvent(new EncounterStatusUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public EncounterStatusId id() {
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
