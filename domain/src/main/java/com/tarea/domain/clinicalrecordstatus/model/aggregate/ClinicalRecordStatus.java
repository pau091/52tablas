package com.tarea.domain.clinicalrecordstatus.model.aggregate;

import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusDeletedEvent;
import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusRegisteredEvent;
import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusUpdatedEvent;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalRecordStatus extends AggregateRoot {

    private final ClinicalRecordStatusId id;
    private String code;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalRecordStatus(
            ClinicalRecordStatusId id,
            String code,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ClinicalRecordStatus register(String code, String name) {
        ClinicalRecordStatusId id = ClinicalRecordStatusId.generate();
        ClinicalRecordStatus clinicalRecordStatus = new ClinicalRecordStatus(
                id,
                code,
                name,
                LocalDateTime.now(),
                null);
        clinicalRecordStatus.recordEvent(new ClinicalRecordStatusRegisteredEvent(id, LocalDateTime.now()));
        return clinicalRecordStatus;
    }

    public static ClinicalRecordStatus restore(
            ClinicalRecordStatusId id,
            String code,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ClinicalRecordStatus(
                id,
                code,
                name,
                createdAt,
                updatedAt);
    }

    public void update(String code, String name) {
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ClinicalRecordStatusUpdatedEvent(
                id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalRecordStatusDeletedEvent(id, LocalDateTime.now()));
    }

    public ClinicalRecordStatusId id() {
        return id;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
