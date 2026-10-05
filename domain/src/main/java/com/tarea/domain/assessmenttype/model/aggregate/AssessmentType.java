package com.tarea.domain.assessmenttype.model.aggregate;

import com.tarea.domain.assessmenttype.event.AssessmentTypeDeletedEvent;
import com.tarea.domain.assessmenttype.event.AssessmentTypeRegisteredEvent;
import com.tarea.domain.assessmenttype.event.AssessmentTypeUpdatedEvent;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class AssessmentType extends AggregateRoot {

    private final AssessmentTypeId id;
    private String code;
    private String name;
    private Boolean active;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AssessmentType(
            AssessmentTypeId id,
            String code,
            String name,
            Boolean active,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.description = description;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static AssessmentType register(
            String code,
            String name,
            Boolean active,
            String description) {
        AssessmentTypeId id = AssessmentTypeId.generate();
        AssessmentType assessmentType = new AssessmentType(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                description,
                LocalDateTime.now(),
                null);
        assessmentType.recordEvent(new AssessmentTypeRegisteredEvent(id, LocalDateTime.now()));
        return assessmentType;
    }

    public static AssessmentType restore(
            AssessmentTypeId id,
            String code,
            String name,
            Boolean active,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new AssessmentType(
                id,
                code,
                name,
                active,
                description,
                createdAt,
                updatedAt);
    }

    public void update(
            String code,
            String name,
            Boolean active,
            String description) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AssessmentTypeUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                this.description,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new AssessmentTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public AssessmentTypeId id() {
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

    public String description() {
        return description;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
