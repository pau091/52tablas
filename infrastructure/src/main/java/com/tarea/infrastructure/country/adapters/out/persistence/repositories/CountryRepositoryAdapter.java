package com.tarea.infrastructure.country.adapters.out.persistence.repositories;

import com.tarea.domain.country.model.aggregate.Country;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.country.port.repository.CountryRepository;
import com.tarea.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class CountryRepositoryAdapter implements CountryRepository {

    private final CountryJpaRepository countryJpaRepository;
    private final CountryPersistenceMapper mapper;

    public CountryRepositoryAdapter(CountryJpaRepository countryJpaRepository, CountryPersistenceMapper mapper) {
        this.countryJpaRepository = countryJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Country save(Country country) {
        return mapper.toDomain(countryJpaRepository.save(mapper.toJpa(country)));
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        return countryJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Country> findAll() {
        return countryJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Country country) {
        countryJpaRepository.deleteById(country.id().value());
    }
}
