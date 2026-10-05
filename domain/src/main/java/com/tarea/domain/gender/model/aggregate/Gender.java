package com.tarea.domain.gender.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.gender.event.GenderDeletedEvent;
import com.tarea.domain.gender.event.GenderRegisteredEvent;
import com.tarea.domain.gender.event.GenderUpdatedEvent;
import com.tarea.domain.gender.model.valueobject.GenderId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Gender extends AggregateRoot {

    private final GenderId id;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Gender(
            GenderId id,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static Gender register(String description) {
        GenderId id = GenderId.generate();
        Gender gender = new Gender(
                id,
                description,
                LocalDateTime.now(),
                null);
        gender.recordEvent(new GenderRegisteredEvent(id, LocalDateTime.now()));
        return gender;
    }

    public static Gender restore(
            GenderId id,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new Gender(
                id,
                description,
                createdAt,
                updatedAt);
    }

    public void update(String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new GenderUpdatedEvent(id, this.description, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new GenderDeletedEvent(id, LocalDateTime.now()));
    }

    public GenderId id() {
        return id;
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
