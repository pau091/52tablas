package com.tarea.domain.professionaltype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.professionaltype.event.ProfessionalTypeDeletedEvent;
import com.tarea.domain.professionaltype.event.ProfessionalTypeRegisteredEvent;
import com.tarea.domain.professionaltype.event.ProfessionalTypeUpdatedEvent;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProfessionalType extends AggregateRoot {

    private final ProfessionalTypeId id;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProfessionalType(
            ProfessionalTypeId id,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ProfessionalType register(String name) {
        ProfessionalTypeId id = ProfessionalTypeId.generate();
        ProfessionalType professionalType = new ProfessionalType(
                id,
                name,
                LocalDateTime.now(),
                null);
        professionalType.recordEvent(new ProfessionalTypeRegisteredEvent(id, LocalDateTime.now()));
        return professionalType;
    }

    public static ProfessionalType restore(
            ProfessionalTypeId id,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ProfessionalType(
                id,
                name,
                createdAt,
                updatedAt);
    }

    public void update(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProfessionalTypeUpdatedEvent(id, this.name, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public ProfessionalTypeId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
