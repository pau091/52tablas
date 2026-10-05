package com.tarea.application.professionalstudy.dto;

import com.tarea.domain.professionalstudy.model.aggregate.ProfessionalStudy;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProfessionalStudyResponse(
        UUID id,
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        Boolean isValid,
        String resolutionNumber,
        UUID countryId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProfessionalStudyResponse fromDomain(ProfessionalStudy professionalStudy) {
        return new ProfessionalStudyResponse(
                professionalStudy.id().value(),
                professionalStudy.studyId().value(),
                professionalStudy.professionalId().value(),
                professionalStudy.title(),
                professionalStudy.university(),
                professionalStudy.isValid(),
                professionalStudy.resolutionNumber(),
                professionalStudy.countryId().value(),
                professionalStudy.createdAt(),
                professionalStudy.updatedAt()
        );
    }
}
