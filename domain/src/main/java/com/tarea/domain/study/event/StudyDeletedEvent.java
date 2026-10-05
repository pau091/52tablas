package com.tarea.domain.study.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StudyDeletedEvent(StudyId id, LocalDateTime occurredOn) implements DomainEvent {

    public StudyDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
