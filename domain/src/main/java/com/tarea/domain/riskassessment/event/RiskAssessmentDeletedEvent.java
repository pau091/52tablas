package com.tarea.domain.riskassessment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskAssessmentDeletedEvent(RiskAssessmentId id, LocalDateTime occurredOn) implements DomainEvent {

    public RiskAssessmentDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
