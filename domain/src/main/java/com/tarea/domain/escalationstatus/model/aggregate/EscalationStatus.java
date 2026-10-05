package com.tarea.domain.escalationstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.escalationstatus.event.EscalationStatusDeletedEvent;
import com.tarea.domain.escalationstatus.event.EscalationStatusRegisteredEvent;
import com.tarea.domain.escalationstatus.event.EscalationStatusUpdatedEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EscalationStatus extends AggregateRoot {

    private final EscalationStatusId id;
    private String nameStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EscalationStatus(
            EscalationStatusId id,
            String nameStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = nameStatus;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static EscalationStatus register(String nameStatus) {
        EscalationStatusId id = EscalationStatusId.generate();
        EscalationStatus escalationStatus = new EscalationStatus(
                id,
                nameStatus,
                LocalDateTime.now(),
                null);
        escalationStatus.recordEvent(new EscalationStatusRegisteredEvent(id, LocalDateTime.now()));
        return escalationStatus;
    }

    public static EscalationStatus restore(
            EscalationStatusId id,
            String nameStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new EscalationStatus(
                id,
                nameStatus,
                createdAt,
                updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = nameStatus;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EscalationStatusUpdatedEvent(id, this.nameStatus, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EscalationStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public EscalationStatusId id() {
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
