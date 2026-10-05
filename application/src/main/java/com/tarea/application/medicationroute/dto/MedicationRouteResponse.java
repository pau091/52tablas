package com.tarea.application.medicationroute.dto;

import com.tarea.domain.medicationroute.model.aggregate.MedicationRoute;

import java.time.LocalDateTime;
import java.util.UUID;

public record MedicationRouteResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static MedicationRouteResponse fromDomain(MedicationRoute medicationRoute) {
        return new MedicationRouteResponse(
                medicationRoute.id().value(),
                medicationRoute.code(),
                medicationRoute.name(),
                medicationRoute.active(),
                medicationRoute.createdAt(),
                medicationRoute.updatedAt()
        );
    }
}
