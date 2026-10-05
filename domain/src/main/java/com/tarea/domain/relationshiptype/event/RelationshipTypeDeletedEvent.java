package com.tarea.domain.relationshiptype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RelationshipTypeDeletedEvent(RelationshipTypeId id, LocalDateTime occurredOn) implements DomainEvent {

    public RelationshipTypeDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
