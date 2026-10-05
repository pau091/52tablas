package com.tarea.domain.risklevel.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskLevelUpdatedEvent(
        RiskLevelId id,
        String code,
        String name,
        Boolean active,
        Integer severity,
        LocalDateTime occurredOn
) implements DomainEvent {

    public RiskLevelUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
