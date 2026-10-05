package com.tarea.domain.encountermodality.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encountermodality.event.EncounterModalityDeletedEvent;
import com.tarea.domain.encountermodality.event.EncounterModalityRegisteredEvent;
import com.tarea.domain.encountermodality.event.EncounterModalityUpdatedEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterModality extends AggregateRoot {

    private final EncounterModalityId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterModality(
            EncounterModalityId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static EncounterModality register(String code, String name, Boolean active) {
        EncounterModalityId id = EncounterModalityId.generate();
        EncounterModality encounterModality = new EncounterModality(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        encounterModality.recordEvent(new EncounterModalityRegisteredEvent(id, LocalDateTime.now()));
        return encounterModality;
    }

    public static EncounterModality restore(
            EncounterModalityId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new EncounterModality(
                id,
                code,
                name,
                active,
                createdAt,
                updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EncounterModalityUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterModalityDeletedEvent(id, LocalDateTime.now()));
    }

    public EncounterModalityId id() {
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
