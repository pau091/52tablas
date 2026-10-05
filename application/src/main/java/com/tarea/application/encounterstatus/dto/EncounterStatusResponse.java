package com.tarea.application.encounterstatus.dto;

import com.tarea.domain.encounterstatus.model.aggregate.EncounterStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record EncounterStatusResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static EncounterStatusResponse fromDomain(EncounterStatus encounterStatus) {
        return new EncounterStatusResponse(
                encounterStatus.id().value(),
                encounterStatus.code(),
                encounterStatus.name(),
                encounterStatus.active(),
                encounterStatus.createdAt(),
                encounterStatus.updatedAt()
        );
    }
}
