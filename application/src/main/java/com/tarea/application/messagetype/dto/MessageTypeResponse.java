package com.tarea.application.messagetype.dto;

import com.tarea.domain.messagetype.model.aggregate.MessageType;

import java.time.LocalDateTime;
import java.util.UUID;

public record MessageTypeResponse(
        UUID id,
        String nameType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static MessageTypeResponse fromDomain(MessageType messageType) {
        return new MessageTypeResponse(
                messageType.id().value(),
                messageType.nameType(),
                messageType.createdAt(),
                messageType.updatedAt()
        );
    }
}
