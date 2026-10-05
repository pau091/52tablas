package com.tarea.application.documenttype.dto;

import com.tarea.domain.documenttype.model.aggregate.DocumentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record DocumentTypeResponse(
        UUID id,
        String code,
        String name,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static DocumentTypeResponse fromDomain(DocumentType documentType) {
        return new DocumentTypeResponse(
                documentType.id().value(),
                documentType.code(),
                documentType.name(),
                documentType.active(),
                documentType.createdAt(),
                documentType.updatedAt()
        );
    }
}
