package com.tarea.domain.diagnosticsystem.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.time.LocalDateTime;
import java.util.Objects;

public record DiagnosticSystemDeletedEvent(DiagnosticSystemId id, LocalDateTime occurredOn) implements DomainEvent {

    public DiagnosticSystemDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
