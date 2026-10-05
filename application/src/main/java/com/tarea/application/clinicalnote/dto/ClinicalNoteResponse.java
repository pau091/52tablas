package com.tarea.application.clinicalnote.dto;

import com.tarea.domain.clinicalnote.model.aggregate.ClinicalNote;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClinicalNoteResponse(
        UUID id,
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        LocalDateTime signedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ClinicalNoteResponse fromDomain(ClinicalNote clinicalNote) {
        return new ClinicalNoteResponse(
                clinicalNote.id().value(),
                clinicalNote.encounterId().value(),
                clinicalNote.professionalId().value(),
                clinicalNote.subjective(),
                clinicalNote.objective(),
                clinicalNote.assessment(),
                clinicalNote.plan(),
                clinicalNote.additionalNotes(),
                clinicalNote.signedAt(),
                clinicalNote.createdAt(),
                clinicalNote.updatedAt()
        );
    }
}
