package com.tarea.domain.country.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.event.CountryDeletedEvent;
import com.tarea.domain.country.event.CountryRegisteredEvent;
import com.tarea.domain.country.event.CountryUpdatedEvent;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Country extends AggregateRoot {

    private final CountryId id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private Boolean isActive;
    private String telephonePrefix;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Country(
            CountryId id,
            String nameCountry,
            String codeCountry,
            String description,
            Boolean isActive,
            String telephonePrefix,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.isActive = isActive;
        this.telephonePrefix = telephonePrefix;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static Country register(
            String nameCountry,
            String codeCountry,
            String description,
            Boolean isActive,
            String telephonePrefix) {
        CountryId id = CountryId.generate();
        Country country = new Country(
                id,
                nameCountry,
                codeCountry,
                description,
                isActive != null ? isActive : Boolean.TRUE,
                telephonePrefix,
                LocalDateTime.now(),
                null);
        country.recordEvent(new CountryRegisteredEvent(id, LocalDateTime.now()));
        return country;
    }

    public static Country restore(
            CountryId id,
            String nameCountry,
            String codeCountry,
            String description,
            Boolean isActive,
            String telephonePrefix,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new Country(
                id,
                nameCountry,
                codeCountry,
                description,
                isActive,
                telephonePrefix,
                createdAt,
                updatedAt);
    }

    public void update(
            String nameCountry,
            String codeCountry,
            String description,
            Boolean isActive,
            String telephonePrefix) {
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.isActive = isActive;
        this.telephonePrefix = telephonePrefix;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new CountryUpdatedEvent(
                id,
                this.nameCountry,
                this.codeCountry,
                this.description,
                this.isActive,
                this.telephonePrefix,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new CountryDeletedEvent(id, LocalDateTime.now()));
    }

    public CountryId id() {
        return id;
    }

    public String nameCountry() {
        return nameCountry;
    }

    public String codeCountry() {
        return codeCountry;
    }

    public String description() {
        return description;
    }

    public Boolean isActive() {
        return isActive;
    }

    public String telephonePrefix() {
        return telephonePrefix;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
