package com.tarea.application.country.usecase;

import com.tarea.application.country.dto.CountryResponse;
import com.tarea.domain.country.port.repository.CountryRepository;

import java.util.List;

public class ListCountriesUseCase {

    private final CountryRepository countryRepository;

    public ListCountriesUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponse> execute() {
        return countryRepository.findAll().stream()
                .map(CountryResponse::fromDomain)
                .toList();
    }
}
