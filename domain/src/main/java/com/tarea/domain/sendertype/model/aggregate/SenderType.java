package com.tarea.domain.sendertype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.sendertype.event.SenderTypeDeletedEvent;
import com.tarea.domain.sendertype.event.SenderTypeRegisteredEvent;
import com.tarea.domain.sendertype.event.SenderTypeUpdatedEvent;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class SenderType extends AggregateRoot {

    private final SenderTypeId id;
    private String nameType;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private SenderType(
            SenderTypeId id,
            String nameType,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameType = nameType;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static SenderType register(String nameType) {
        SenderTypeId id = SenderTypeId.generate();
        SenderType senderType = new SenderType(
                id,
                nameType,
                LocalDateTime.now(),
                null);
        senderType.recordEvent(new SenderTypeRegisteredEvent(id, LocalDateTime.now()));
        return senderType;
    }

    public static SenderType restore(
            SenderTypeId id,
            String nameType,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new SenderType(
                id,
                nameType,
                createdAt,
                updatedAt);
    }

    public void update(String nameType) {
        this.nameType = nameType;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new SenderTypeUpdatedEvent(id, this.nameType, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new SenderTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public SenderTypeId id() {
        return id;
    }

    public String nameType() {
        return nameType;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
