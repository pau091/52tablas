package com.tarea.application.contact.dto;

import com.tarea.domain.contact.model.aggregate.Contact;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContactResponse(
        UUID id,
        String fullName,
        String email,
        String notes,
        UUID cityId,
        LocalDateTime createdAt,
        UUID createdBy,
        LocalDateTime updatedAt,
        UUID updatedBy
) {

    public static ContactResponse fromDomain(Contact contact) {
        return new ContactResponse(
                contact.id().value(),
                contact.fullName(),
                contact.email(),
                contact.notes(),
                contact.cityId().value(),
                contact.createdAt(),
                contact.createdBy().value(),
                contact.updatedAt(),
                contact.updatedBy() != null ? contact.updatedBy().value() : null
        );
    }
}
