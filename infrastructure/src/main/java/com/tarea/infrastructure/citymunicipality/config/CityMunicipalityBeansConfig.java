package com.tarea.infrastructure.citymunicipality.config;

import com.tarea.application.citymunicipality.usecase.DeleteCityMunicipalityUseCase;
import com.tarea.application.citymunicipality.usecase.GetCityMunicipalityByIdUseCase;
import com.tarea.application.citymunicipality.usecase.ListCityMunicipalitiesUseCase;
import com.tarea.application.citymunicipality.usecase.RegisterCityMunicipalityUseCase;
import com.tarea.application.citymunicipality.usecase.UpdateCityMunicipalityUseCase;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityPersistenceMapper;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityJpaRepository;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityMunicipalityBeansConfig {

    @Bean
    public CityMunicipalityPersistenceMapper cityMunicipalityPersistenceMapper() {
        return new CityMunicipalityPersistenceMapper();
    }

    @Bean
    public CityMunicipalityRepository cityMunicipalityRepository(CityMunicipalityJpaRepository cityMunicipalityJpaRepository, CityMunicipalityPersistenceMapper cityMunicipalityPersistenceMapper) {
        return new CityMunicipalityRepositoryAdapter(cityMunicipalityJpaRepository, cityMunicipalityPersistenceMapper);
    }

    @Bean
    public RegisterCityMunicipalityUseCase registerCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        return new RegisterCityMunicipalityUseCase(cityMunicipalityRepository);
    }

    @Bean
    public GetCityMunicipalityByIdUseCase getCityMunicipalityByIdUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        return new GetCityMunicipalityByIdUseCase(cityMunicipalityRepository);
    }

    @Bean
    public ListCityMunicipalitiesUseCase listCityMunicipalitiesUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        return new ListCityMunicipalitiesUseCase(cityMunicipalityRepository);
    }

    @Bean
    public UpdateCityMunicipalityUseCase updateCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        return new UpdateCityMunicipalityUseCase(cityMunicipalityRepository);
    }

    @Bean
    public DeleteCityMunicipalityUseCase deleteCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        return new DeleteCityMunicipalityUseCase(cityMunicipalityRepository);
    }
}
