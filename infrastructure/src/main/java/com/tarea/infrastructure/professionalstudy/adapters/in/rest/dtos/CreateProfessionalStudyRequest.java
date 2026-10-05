package com.tarea.infrastructure.professionalstudy.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateProfessionalStudyRequest(
        @NotNull UUID studyId,
        @NotNull UUID professionalId,
        @Size(max = 100) String title,
        @Size(max = 100) String university,
        Boolean isValid,
        @Size(max = 60) String resolutionNumber,
        @NotNull UUID countryId
) {
}
