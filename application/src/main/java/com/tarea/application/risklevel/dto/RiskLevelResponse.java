package com.tarea.application.risklevel.dto;

import com.tarea.domain.risklevel.model.aggregate.RiskLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public record RiskLevelResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        Integer severity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static RiskLevelResponse fromDomain(RiskLevel riskLevel) {
        return new RiskLevelResponse(
                riskLevel.id().value(),
                riskLevel.code(),
                riskLevel.name(),
                riskLevel.active(),
                riskLevel.severity(),
                riskLevel.createdAt(),
                riskLevel.updatedAt()
        );
    }
}
