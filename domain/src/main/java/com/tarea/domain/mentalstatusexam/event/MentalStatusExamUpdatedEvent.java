package com.tarea.domain.mentalstatusexam.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MentalStatusExamUpdatedEvent(
        MentalStatusExamId id,
        EncounterId encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations,
        LocalDateTime occurredOn
) implements DomainEvent {

    public MentalStatusExamUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
