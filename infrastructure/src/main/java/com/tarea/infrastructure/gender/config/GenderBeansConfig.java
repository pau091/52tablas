package com.tarea.infrastructure.gender.config;

import com.tarea.application.gender.usecase.DeleteGenderUseCase;
import com.tarea.application.gender.usecase.GetGenderByIdUseCase;
import com.tarea.application.gender.usecase.ListGendersUseCase;
import com.tarea.application.gender.usecase.RegisterGenderUseCase;
import com.tarea.application.gender.usecase.UpdateGenderUseCase;
import com.tarea.domain.gender.port.repository.GenderRepository;
import com.tarea.infrastructure.gender.adapters.out.persistence.mappers.GenderPersistenceMapper;
import com.tarea.infrastructure.gender.adapters.out.persistence.repositories.GenderJpaRepository;
import com.tarea.infrastructure.gender.adapters.out.persistence.repositories.GenderRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenderBeansConfig {

    @Bean
    public GenderPersistenceMapper genderPersistenceMapper() {
        return new GenderPersistenceMapper();
    }

    @Bean
    public GenderRepository genderRepository(GenderJpaRepository genderJpaRepository, GenderPersistenceMapper genderPersistenceMapper) {
        return new GenderRepositoryAdapter(genderJpaRepository, genderPersistenceMapper);
    }

    @Bean
    public RegisterGenderUseCase registerGenderUseCase(GenderRepository genderRepository) {
        return new RegisterGenderUseCase(genderRepository);
    }

    @Bean
    public GetGenderByIdUseCase getGenderByIdUseCase(GenderRepository genderRepository) {
        return new GetGenderByIdUseCase(genderRepository);
    }

    @Bean
    public ListGendersUseCase listGendersUseCase(GenderRepository genderRepository) {
        return new ListGendersUseCase(genderRepository);
    }

    @Bean
    public UpdateGenderUseCase updateGenderUseCase(GenderRepository genderRepository) {
        return new UpdateGenderUseCase(genderRepository);
    }

    @Bean
    public DeleteGenderUseCase deleteGenderUseCase(GenderRepository genderRepository) {
        return new DeleteGenderUseCase(genderRepository);
    }
}
