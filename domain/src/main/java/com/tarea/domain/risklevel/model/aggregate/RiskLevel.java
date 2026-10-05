package com.tarea.domain.risklevel.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.risklevel.event.RiskLevelDeletedEvent;
import com.tarea.domain.risklevel.event.RiskLevelRegisteredEvent;
import com.tarea.domain.risklevel.event.RiskLevelUpdatedEvent;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public class RiskLevel extends AggregateRoot {

    private final RiskLevelId id;
    private String code;
    private String name;
    private Boolean active;
    private Integer severity;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private RiskLevel(
            RiskLevelId id,
            String code,
            String name,
            Boolean active,
            Integer severity,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.severity = severity;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static RiskLevel register(
            String code,
            String name,
            Boolean active,
            Integer severity) {
        RiskLevelId id = RiskLevelId.generate();
        RiskLevel riskLevel = new RiskLevel(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                severity,
                LocalDateTime.now(),
                null);
        riskLevel.recordEvent(new RiskLevelRegisteredEvent(id, LocalDateTime.now()));
        return riskLevel;
    }

    public static RiskLevel restore(
            RiskLevelId id,
            String code,
            String name,
            Boolean active,
            Integer severity,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new RiskLevel(
                id,
                code,
                name,
                active,
                severity,
                createdAt,
                updatedAt);
    }

    public void update(
            String code,
            String name,
            Boolean active,
            Integer severity) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.severity = severity;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new RiskLevelUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                this.severity,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new RiskLevelDeletedEvent(id, LocalDateTime.now()));
    }

    public RiskLevelId id() {
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

    public Integer severity() {
        return severity;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
