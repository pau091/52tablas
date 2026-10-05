package com.tarea.application.gender.dto;

import com.tarea.domain.gender.model.aggregate.Gender;

import java.time.LocalDateTime;
import java.util.UUID;

public record GenderResponse(
        UUID id,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static GenderResponse fromDomain(Gender gender) {
        return new GenderResponse(
                gender.id().value(),
                gender.description(),
                gender.createdAt(),
                gender.updatedAt()
        );
    }
}
