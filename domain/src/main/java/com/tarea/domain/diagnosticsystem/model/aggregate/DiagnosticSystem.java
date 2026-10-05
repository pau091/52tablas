package com.tarea.domain.diagnosticsystem.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemDeletedEvent;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemRegisteredEvent;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemUpdatedEvent;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.time.LocalDateTime;
import java.util.Objects;

public class DiagnosticSystem extends AggregateRoot {

    private final DiagnosticSystemId id;
    private String code;
    private String name;
    private Boolean active;
    private String version;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DiagnosticSystem(
            DiagnosticSystemId id,
            String code,
            String name,
            Boolean active,
            String version,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.version = version;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static DiagnosticSystem register(
            String code,
            String name,
            Boolean active,
            String version) {
        DiagnosticSystemId id = DiagnosticSystemId.generate();
        DiagnosticSystem diagnosticSystem = new DiagnosticSystem(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                version,
                LocalDateTime.now(),
                null);
        diagnosticSystem.recordEvent(new DiagnosticSystemRegisteredEvent(id, LocalDateTime.now()));
        return diagnosticSystem;
    }

    public static DiagnosticSystem restore(
            DiagnosticSystemId id,
            String code,
            String name,
            Boolean active,
            String version,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new DiagnosticSystem(
                id,
                code,
                name,
                active,
                version,
                createdAt,
                updatedAt);
    }

    public void update(
            String code,
            String name,
            Boolean active,
            String version) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.version = version;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new DiagnosticSystemUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                this.version,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new DiagnosticSystemDeletedEvent(id, LocalDateTime.now()));
    }

    public DiagnosticSystemId id() {
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

    public String version() {
        return version;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
