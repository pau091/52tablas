package com.tarea.domain.stateregion.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.stateregion.event.StateRegionDeletedEvent;
import com.tarea.domain.stateregion.event.StateRegionRegisteredEvent;
import com.tarea.domain.stateregion.event.StateRegionUpdatedEvent;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public class StateRegion extends AggregateRoot {

    private final StateRegionId id;
    private String nameRegion;
    private String codeRegion;
    private String description;
    private Boolean isActive;
    private CountryId countryId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private StateRegion(
            StateRegionId id,
            String nameRegion,
            String codeRegion,
            String description,
            Boolean isActive,
            CountryId countryId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameRegion = nameRegion;
        this.codeRegion = codeRegion;
        this.description = description;
        this.isActive = isActive;
        this.countryId = Objects.requireNonNull(countryId, "countryId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static StateRegion register(
            String nameRegion,
            String codeRegion,
            String description,
            Boolean isActive,
            CountryId countryId) {
        StateRegionId id = StateRegionId.generate();
        StateRegion stateRegion = new StateRegion(
                id,
                nameRegion,
                codeRegion,
                description,
                isActive != null ? isActive : Boolean.TRUE,
                countryId,
                LocalDateTime.now(),
                null);
        stateRegion.recordEvent(new StateRegionRegisteredEvent(id, LocalDateTime.now()));
        return stateRegion;
    }

    public static StateRegion restore(
            StateRegionId id,
            String nameRegion,
            String codeRegion,
            String description,
            Boolean isActive,
            CountryId countryId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new StateRegion(
                id,
                nameRegion,
                codeRegion,
                description,
                isActive,
                countryId,
                createdAt,
                updatedAt);
    }

    public void update(
            String nameRegion,
            String codeRegion,
            String description,
            Boolean isActive,
            CountryId countryId) {
        this.nameRegion = nameRegion;
        this.codeRegion = codeRegion;
        this.description = description;
        this.isActive = isActive;
        this.countryId = Objects.requireNonNull(countryId, "countryId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new StateRegionUpdatedEvent(
                id,
                this.nameRegion,
                this.codeRegion,
                this.description,
                this.isActive,
                this.countryId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new StateRegionDeletedEvent(id, LocalDateTime.now()));
    }

    public StateRegionId id() {
        return id;
    }

    public String nameRegion() {
        return nameRegion;
    }

    public String codeRegion() {
        return codeRegion;
    }

    public String description() {
        return description;
    }

    public Boolean isActive() {
        return isActive;
    }

    public CountryId countryId() {
        return countryId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
