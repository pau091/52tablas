package com.tarea.application.encountertype.dto;

import com.tarea.domain.encountertype.model.aggregate.EncounterType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EncounterTypeResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static EncounterTypeResponse fromDomain(EncounterType encounterType) {
        return new EncounterTypeResponse(
                encounterType.id().value(),
                encounterType.code(),
                encounterType.name(),
                encounterType.active(),
                encounterType.createdAt(),
                encounterType.updatedAt()
        );
    }
}
