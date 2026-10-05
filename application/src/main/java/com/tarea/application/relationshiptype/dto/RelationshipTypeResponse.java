package com.tarea.application.relationshiptype.dto;

import com.tarea.domain.relationshiptype.model.aggregate.RelationshipType;

import java.util.UUID;

public record RelationshipTypeResponse(
        UUID id,
        String description
) {

    public static RelationshipTypeResponse fromDomain(RelationshipType relationshipType) {
        return new RelationshipTypeResponse(
                relationshipType.id().value(),
                relationshipType.description()
        );
    }
}
