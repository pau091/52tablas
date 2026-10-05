package com.tarea.domain.emailcontact.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.emailcontact.event.EmailContactDeletedEvent;
import com.tarea.domain.emailcontact.event.EmailContactRegisteredEvent;
import com.tarea.domain.emailcontact.event.EmailContactUpdatedEvent;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EmailContact extends AggregateRoot {

    private final EmailContactId id;
    private ContactId contactId;
    private String email;
    private String notes;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EmailContact(
            EmailContactId id,
            ContactId contactId,
            String email,
            String notes,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.notes = notes;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static EmailContact register(ContactId contactId, String email, String notes) {
        EmailContactId id = EmailContactId.generate();
        EmailContact emailContact = new EmailContact(
                id,
                contactId,
                email,
                notes,
                LocalDateTime.now(),
                null);
        emailContact.recordEvent(new EmailContactRegisteredEvent(id, LocalDateTime.now()));
        return emailContact;
    }

    public static EmailContact restore(
            EmailContactId id,
            ContactId contactId,
            String email,
            String notes,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new EmailContact(
                id,
                contactId,
                email,
                notes,
                createdAt,
                updatedAt);
    }

    public void update(ContactId contactId, String email, String notes) {
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.notes = notes;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EmailContactUpdatedEvent(
                id,
                this.contactId,
                this.email,
                this.notes,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new EmailContactDeletedEvent(id, LocalDateTime.now()));
    }

    public EmailContactId id() {
        return id;
    }

    public ContactId contactId() {
        return contactId;
    }

    public String email() {
        return email;
    }

    public String notes() {
        return notes;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
