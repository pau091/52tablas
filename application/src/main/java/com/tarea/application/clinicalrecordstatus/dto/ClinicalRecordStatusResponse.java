package com.tarea.application.clinicalrecordstatus.dto;

import com.tarea.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClinicalRecordStatusResponse(
        UUID id,
        String code,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ClinicalRecordStatusResponse fromDomain(ClinicalRecordStatus clinicalRecordStatus) {
        return new ClinicalRecordStatusResponse(
                clinicalRecordStatus.id().value(),
                clinicalRecordStatus.code(),
                clinicalRecordStatus.name(),
                clinicalRecordStatus.createdAt(),
                clinicalRecordStatus.updatedAt()
        );
    }
}
