package com.tarea.application.sendertype.dto;

import com.tarea.domain.sendertype.model.aggregate.SenderType;

import java.time.LocalDateTime;
import java.util.UUID;

public record SenderTypeResponse(
        UUID id,
        String nameType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static SenderTypeResponse fromDomain(SenderType senderType) {
        return new SenderTypeResponse(
                senderType.id().value(),
                senderType.nameType(),
                senderType.createdAt(),
                senderType.updatedAt()
        );
    }
}
