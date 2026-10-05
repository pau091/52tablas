package com.tarea.application.encountermodality.dto;

import com.tarea.domain.encountermodality.model.aggregate.EncounterModality;

import java.time.LocalDateTime;
import java.util.UUID;

public record EncounterModalityResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static EncounterModalityResponse fromDomain(EncounterModality encounterModality) {
        return new EncounterModalityResponse(
                encounterModality.id().value(),
                encounterModality.code(),
                encounterModality.name(),
                encounterModality.active(),
                encounterModality.createdAt(),
                encounterModality.updatedAt()
        );
    }
}
