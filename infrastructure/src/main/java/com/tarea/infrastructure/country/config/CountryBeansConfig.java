package com.tarea.infrastructure.country.config;

import com.tarea.application.country.usecase.DeleteCountryUseCase;
import com.tarea.application.country.usecase.GetCountryByIdUseCase;
import com.tarea.application.country.usecase.ListCountriesUseCase;
import com.tarea.application.country.usecase.RegisterCountryUseCase;
import com.tarea.application.country.usecase.UpdateCountryUseCase;
import com.tarea.domain.country.port.repository.CountryRepository;
import com.tarea.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;
import com.tarea.infrastructure.country.adapters.out.persistence.repositories.CountryJpaRepository;
import com.tarea.infrastructure.country.adapters.out.persistence.repositories.CountryRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryBeansConfig {

    @Bean
    public CountryPersistenceMapper countryPersistenceMapper() {
        return new CountryPersistenceMapper();
    }

    @Bean
    public CountryRepository countryRepository(CountryJpaRepository countryJpaRepository, CountryPersistenceMapper countryPersistenceMapper) {
        return new CountryRepositoryAdapter(countryJpaRepository, countryPersistenceMapper);
    }

    @Bean
    public RegisterCountryUseCase registerCountryUseCase(CountryRepository countryRepository) {
        return new RegisterCountryUseCase(countryRepository);
    }

    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryRepository countryRepository) {
        return new GetCountryByIdUseCase(countryRepository);
    }

    @Bean
    public ListCountriesUseCase listCountriesUseCase(CountryRepository countryRepository) {
        return new ListCountriesUseCase(countryRepository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository countryRepository) {
        return new UpdateCountryUseCase(countryRepository);
    }

    @Bean
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository countryRepository) {
        return new DeleteCountryUseCase(countryRepository);
    }
}
