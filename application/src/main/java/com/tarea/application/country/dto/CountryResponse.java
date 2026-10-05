package com.tarea.application.country.dto;

import com.tarea.domain.country.model.aggregate.Country;

import java.time.LocalDateTime;
import java.util.UUID;

public record CountryResponse(
        UUID id,
        String nameCountry,
        String codeCountry,
        String description,
        Boolean isActive,
        String telephonePrefix,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static CountryResponse fromDomain(Country country) {
        return new CountryResponse(
                country.id().value(),
                country.nameCountry(),
                country.codeCountry(),
                country.description(),
                country.isActive(),
                country.telephonePrefix(),
                country.createdAt(),
                country.updatedAt()
        );
    }
}
