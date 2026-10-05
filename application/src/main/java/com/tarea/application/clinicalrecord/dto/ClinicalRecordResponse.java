package com.tarea.application.clinicalrecord.dto;

import com.tarea.domain.clinicalrecord.model.aggregate.ClinicalRecord;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClinicalRecordResponse(
        UUID id,
        UUID patientId,
        LocalDateTime creationDate,
        String recordNumber,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        UUID statusId,
        LocalDateTime createdAt,
        UUID createdBy
) {

    public static ClinicalRecordResponse fromDomain(ClinicalRecord clinicalRecord) {
        return new ClinicalRecordResponse(
                clinicalRecord.id().value(),
                clinicalRecord.patientId().value(),
                clinicalRecord.creationDate(),
                clinicalRecord.recordNumber(),
                clinicalRecord.openedAt(),
                clinicalRecord.closedAt(),
                clinicalRecord.statusId().value(),
                clinicalRecord.createdAt(),
                clinicalRecord.createdBy().value()
        );
    }
}
