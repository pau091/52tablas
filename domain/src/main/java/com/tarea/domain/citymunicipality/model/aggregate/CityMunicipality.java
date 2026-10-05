package com.tarea.domain.citymunicipality.model.aggregate;

import com.tarea.domain.citymunicipality.event.CityMunicipalityDeletedEvent;
import com.tarea.domain.citymunicipality.event.CityMunicipalityRegisteredEvent;
import com.tarea.domain.citymunicipality.event.CityMunicipalityUpdatedEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public class CityMunicipality extends AggregateRoot {

    private final CityMunicipalityId id;
    private String nameCity;
    private String codeCity;
    private String description;
    private Boolean isActive;
    private StateRegionId regionId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private CityMunicipality(
            CityMunicipalityId id,
            String nameCity,
            String codeCity,
            String description,
            Boolean isActive,
            StateRegionId regionId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameCity = nameCity;
        this.codeCity = codeCity;
        this.description = description;
        this.isActive = isActive;
        this.regionId = Objects.requireNonNull(regionId, "regionId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static CityMunicipality register(
            String nameCity,
            String codeCity,
            String description,
            Boolean isActive,
            StateRegionId regionId) {
        CityMunicipalityId id = CityMunicipalityId.generate();
        CityMunicipality cityMunicipality = new CityMunicipality(
                id,
                nameCity,
                codeCity,
                description,
                isActive != null ? isActive : Boolean.TRUE,
                regionId,
                LocalDateTime.now(),
                null);
        cityMunicipality.recordEvent(new CityMunicipalityRegisteredEvent(id, LocalDateTime.now()));
        return cityMunicipality;
    }

    public static CityMunicipality restore(
            CityMunicipalityId id,
            String nameCity,
            String codeCity,
            String description,
            Boolean isActive,
            StateRegionId regionId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new CityMunicipality(
                id,
                nameCity,
                codeCity,
                description,
                isActive,
                regionId,
                createdAt,
                updatedAt);
    }

    public void update(
            String nameCity,
            String codeCity,
            String description,
            Boolean isActive,
            StateRegionId regionId) {
        this.nameCity = nameCity;
        this.codeCity = codeCity;
        this.description = description;
        this.isActive = isActive;
        this.regionId = Objects.requireNonNull(regionId, "regionId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new CityMunicipalityUpdatedEvent(
                id,
                this.nameCity,
                this.codeCity,
                this.description,
                this.isActive,
                this.regionId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new CityMunicipalityDeletedEvent(id, LocalDateTime.now()));
    }

    public CityMunicipalityId id() {
        return id;
    }

    public String nameCity() {
        return nameCity;
    }

    public String codeCity() {
        return codeCity;
    }

    public String description() {
        return description;
    }

    public Boolean isActive() {
        return isActive;
    }

    public StateRegionId regionId() {
        return regionId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
