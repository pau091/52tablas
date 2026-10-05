package com.tarea.domain.airunstatus.model.aggregate;

import com.tarea.domain.airunstatus.event.AiRunStatusDeletedEvent;
import com.tarea.domain.airunstatus.event.AiRunStatusRegisteredEvent;
import com.tarea.domain.airunstatus.event.AiRunStatusUpdatedEvent;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class AiRunStatus extends AggregateRoot {

    private final AiRunStatusId id;
    private String nameStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiRunStatus(
            AiRunStatusId id,
            String nameStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = nameStatus;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static AiRunStatus register(String nameStatus) {
        AiRunStatusId id = AiRunStatusId.generate();
        AiRunStatus aiRunStatus = new AiRunStatus(
                id,
                nameStatus,
                LocalDateTime.now(),
                null);
        aiRunStatus.recordEvent(new AiRunStatusRegisteredEvent(id, LocalDateTime.now()));
        return aiRunStatus;
    }

    public static AiRunStatus restore(
            AiRunStatusId id,
            String nameStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new AiRunStatus(
                id,
                nameStatus,
                createdAt,
                updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = nameStatus;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AiRunStatusUpdatedEvent(id, this.nameStatus, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new AiRunStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public AiRunStatusId id() {
        return id;
    }

    public String nameStatus() {
        return nameStatus;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
