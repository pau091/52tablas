package com.tarea.infrastructure.study.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

public record CreateStudyRequest(
        @Size(max = 40) String name
) {
}
