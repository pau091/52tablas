package com.tarea.domain.priority.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.priority.event.PriorityDeletedEvent;
import com.tarea.domain.priority.event.PriorityRegisteredEvent;
import com.tarea.domain.priority.event.PriorityUpdatedEvent;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Priority extends AggregateRoot {

    private final PriorityId id;
    private String namePriority;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Priority(
            PriorityId id,
            String namePriority,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.namePriority = namePriority;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static Priority register(String namePriority) {
        PriorityId id = PriorityId.generate();
        Priority priority = new Priority(
                id,
                namePriority,
                LocalDateTime.now(),
                null);
        priority.recordEvent(new PriorityRegisteredEvent(id, LocalDateTime.now()));
        return priority;
    }

    public static Priority restore(
            PriorityId id,
            String namePriority,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new Priority(
                id,
                namePriority,
                createdAt,
                updatedAt);
    }

    public void update(String namePriority) {
        this.namePriority = namePriority;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PriorityUpdatedEvent(id, this.namePriority, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PriorityDeletedEvent(id, LocalDateTime.now()));
    }

    public PriorityId id() {
        return id;
    }

    public String namePriority() {
        return namePriority;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
