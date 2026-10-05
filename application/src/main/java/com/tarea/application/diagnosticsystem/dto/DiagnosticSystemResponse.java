package com.tarea.application.diagnosticsystem.dto;

import com.tarea.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public record DiagnosticSystemResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        String version,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static DiagnosticSystemResponse fromDomain(DiagnosticSystem diagnosticSystem) {
        return new DiagnosticSystemResponse(
                diagnosticSystem.id().value(),
                diagnosticSystem.code(),
                diagnosticSystem.name(),
                diagnosticSystem.active(),
                diagnosticSystem.version(),
                diagnosticSystem.createdAt(),
                diagnosticSystem.updatedAt()
        );
    }
}
