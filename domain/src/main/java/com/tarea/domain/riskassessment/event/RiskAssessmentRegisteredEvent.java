package com.tarea.domain.riskassessment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskAssessmentRegisteredEvent(RiskAssessmentId id, LocalDateTime occurredOn) implements DomainEvent {

    public RiskAssessmentRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
