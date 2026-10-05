package com.tarea.application.phonecontact.dto;

import com.tarea.domain.phonecontact.model.aggregate.PhoneContact;

import java.util.UUID;

public record PhoneContactResponse(
        UUID id,
        UUID contactId,
        String phone,
        String notes
) {

    public static PhoneContactResponse fromDomain(PhoneContact phoneContact) {
        return new PhoneContactResponse(
                phoneContact.id().value(),
                phoneContact.contactId().value(),
                phoneContact.phone(),
                phoneContact.notes()
        );
    }
}
