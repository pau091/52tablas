package com.tarea.domain.assessmenttype.event;

import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.tarea.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public record AssessmentTypeUpdatedEvent(
        AssessmentTypeId id,
        String code,
        String name,
        Boolean active,
        String description,
        LocalDateTime occurredOn
) implements DomainEvent {

    public AssessmentTypeUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
