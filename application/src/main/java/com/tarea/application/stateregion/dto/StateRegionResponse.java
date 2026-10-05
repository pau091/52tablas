package com.tarea.application.stateregion.dto;

import com.tarea.domain.stateregion.model.aggregate.StateRegion;

import java.time.LocalDateTime;
import java.util.UUID;

public record StateRegionResponse(
        UUID id,
        String nameRegion,
        String codeRegion,
        String description,
        Boolean isActive,
        UUID countryId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static StateRegionResponse fromDomain(StateRegion stateRegion) {
        return new StateRegionResponse(
                stateRegion.id().value(),
                stateRegion.nameRegion(),
                stateRegion.codeRegion(),
                stateRegion.description(),
                stateRegion.isActive(),
                stateRegion.countryId().value(),
                stateRegion.createdAt(),
                stateRegion.updatedAt()
        );
    }
}
