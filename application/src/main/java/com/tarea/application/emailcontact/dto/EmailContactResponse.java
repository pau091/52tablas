package com.tarea.application.emailcontact.dto;

import com.tarea.domain.emailcontact.model.aggregate.EmailContact;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailContactResponse(
        UUID id,
        UUID contactId,
        String email,
        String notes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static EmailContactResponse fromDomain(EmailContact emailContact) {
        return new EmailContactResponse(
                emailContact.id().value(),
                emailContact.contactId().value(),
                emailContact.email(),
                emailContact.notes(),
                emailContact.createdAt(),
                emailContact.updatedAt()
        );
    }
}
