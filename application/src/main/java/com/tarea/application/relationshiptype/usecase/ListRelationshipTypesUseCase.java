package com.tarea.application.relationshiptype.usecase;

import com.tarea.application.relationshiptype.dto.RelationshipTypeResponse;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;

import java.util.List;

public class ListRelationshipTypesUseCase {

    private final RelationshipTypeRepository relationshipTypeRepository;

    public ListRelationshipTypesUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public List<RelationshipTypeResponse> execute() {
        return relationshipTypeRepository.findAll().stream()
                .map(RelationshipTypeResponse::fromDomain)
                .toList();
    }
}
