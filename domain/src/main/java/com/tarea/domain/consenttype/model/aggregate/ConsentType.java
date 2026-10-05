package com.tarea.domain.consenttype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.consenttype.event.ConsentTypeDeletedEvent;
import com.tarea.domain.consenttype.event.ConsentTypeRegisteredEvent;
import com.tarea.domain.consenttype.event.ConsentTypeUpdatedEvent;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConsentType extends AggregateRoot {

    private final ConsentTypeId id;
    private String code;
    private String name;
    private Boolean active;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ConsentType(
            ConsentTypeId id,
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

    public static ConsentType register(
            String code,
            String name,
            Boolean active,
            String description) {
        ConsentTypeId id = ConsentTypeId.generate();
        ConsentType consentType = new ConsentType(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                description,
                LocalDateTime.now(),
                null);
        consentType.recordEvent(new ConsentTypeRegisteredEvent(id, LocalDateTime.now()));
        return consentType;
    }

    public static ConsentType restore(
            ConsentTypeId id,
            String code,
            String name,
            Boolean active,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ConsentType(
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
        recordEvent(new ConsentTypeUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                this.description,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ConsentTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public ConsentTypeId id() {
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
