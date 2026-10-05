package com.tarea.infrastructure.assessmenttype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAssessmentTypeRequest(
        @NotBlank @Size(max = 20) String code,
        @Size(max = 50) String name,
        Boolean active,
        String description
) {
}
