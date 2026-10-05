package com.tarea.domain.professionalstudy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalStudyRegisteredEvent(ProfessionalStudyId id, LocalDateTime occurredOn) implements DomainEvent {

    public ProfessionalStudyRegisteredEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
