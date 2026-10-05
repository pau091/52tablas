package com.tarea.application.encounter.dto;

import com.tarea.domain.encounter.model.aggregate.Encounter;

import java.time.LocalDateTime;
import java.util.UUID;

public record EncounterResponse(
        UUID id,
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        LocalDateTime createdAt,
        UUID createdBy,
        LocalDateTime updatedAt,
        UUID updatedBy
) {

    public static EncounterResponse fromDomain(Encounter encounter) {
        return new EncounterResponse(
                encounter.id().value(),
                encounter.clinicalRecordId().value(),
                encounter.professionalId().value(),
                encounter.encounterTypeId().value(),
                encounter.startedAt(),
                encounter.endedAt(),
                encounter.reasonForVisit(),
                encounter.currentCondition(),
                encounter.modalityId().value(),
                encounter.statusId().value(),
                encounter.createdAt(),
                encounter.createdBy(),
                encounter.updatedAt(),
                encounter.updatedBy()
        );
    }
}
