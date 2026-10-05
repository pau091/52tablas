package com.tarea.domain.encountertype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encountertype.event.EncounterTypeDeletedEvent;
import com.tarea.domain.encountertype.event.EncounterTypeRegisteredEvent;
import com.tarea.domain.encountertype.event.EncounterTypeUpdatedEvent;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterType extends AggregateRoot {

    private final EncounterTypeId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterType(
            EncounterTypeId id,
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

    public static EncounterType register(String code, String name, Boolean active) {
        EncounterTypeId id = EncounterTypeId.generate();
        EncounterType encounterType = new EncounterType(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        encounterType.recordEvent(new EncounterTypeRegisteredEvent(id, LocalDateTime.now()));
        return encounterType;
    }

    public static EncounterType restore(
            EncounterTypeId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new EncounterType(
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
        recordEvent(new EncounterTypeUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public EncounterTypeId id() {
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
