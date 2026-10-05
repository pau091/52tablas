package com.tarea.domain.medicationroute.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.medicationroute.event.MedicationRouteDeletedEvent;
import com.tarea.domain.medicationroute.event.MedicationRouteRegisteredEvent;
import com.tarea.domain.medicationroute.event.MedicationRouteUpdatedEvent;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.time.LocalDateTime;
import java.util.Objects;

public class MedicationRoute extends AggregateRoot {

    private final MedicationRouteId id;
    private String code;
    private String name;
    private Boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private MedicationRoute(
            MedicationRouteId id,
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

    public static MedicationRoute register(String code, String name, Boolean active) {
        MedicationRouteId id = MedicationRouteId.generate();
        MedicationRoute medicationRoute = new MedicationRoute(
                id,
                code,
                name,
                active != null ? active : Boolean.TRUE,
                LocalDateTime.now(),
                null);
        medicationRoute.recordEvent(new MedicationRouteRegisteredEvent(id, LocalDateTime.now()));
        return medicationRoute;
    }

    public static MedicationRoute restore(
            MedicationRouteId id,
            String code,
            String name,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new MedicationRoute(
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
        recordEvent(new MedicationRouteUpdatedEvent(
                id,
                this.code,
                this.name,
                this.active,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new MedicationRouteDeletedEvent(id, LocalDateTime.now()));
    }

    public MedicationRouteId id() {
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
