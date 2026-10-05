package com.tarea.domain.documenttype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.documenttype.event.DocumentTypeDeletedEvent;
import com.tarea.domain.documenttype.event.DocumentTypeRegisteredEvent;
import com.tarea.domain.documenttype.event.DocumentTypeUpdatedEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class DocumentType extends AggregateRoot {

    private final DocumentTypeId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DocumentType(
            DocumentTypeId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static DocumentType register(String code, String name, Boolean active) {
        DocumentTypeId id = DocumentTypeId.generate();
        DocumentType documentType = new DocumentType(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        documentType.recordEvent(new DocumentTypeRegisteredEvent(id, LocalDateTime.now()));
        return documentType;
    }

    public static DocumentType restore(
            DocumentTypeId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new DocumentType(
                id,
                code,
                name,
                active,
                createdAt,
                updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = name;
        this.active = active;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new DocumentTypeUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new DocumentTypeDeletedEvent(id, LocalDateTime.now()));
    }

    public DocumentTypeId id() {
        return id;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }

    public Boolean active() {
        return active;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
