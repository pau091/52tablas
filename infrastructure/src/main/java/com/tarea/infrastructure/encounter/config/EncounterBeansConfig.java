package com.tarea.infrastructure.encounter.config;

import com.tarea.application.encounter.usecase.DeleteEncounterUseCase;
import com.tarea.application.encounter.usecase.GetEncounterByIdUseCase;
import com.tarea.application.encounter.usecase.ListEncounterUseCase;
import com.tarea.application.encounter.usecase.RegisterEncounterUseCase;
import com.tarea.application.encounter.usecase.UpdateEncounterUseCase;
import com.tarea.domain.encounter.port.repository.EncounterRepository;
import com.tarea.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;
import com.tarea.infrastructure.encounter.adapters.out.persistence.repositories.EncounterJpaRepository;
import com.tarea.infrastructure.encounter.adapters.out.persistence.repositories.EncounterRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterBeansConfig {

    @Bean
    public EncounterPersistenceMapper encounterPersistenceMapper() {
        return new EncounterPersistenceMapper();
    }

    @Bean
    public EncounterRepository encounterRepository(EncounterJpaRepository encounterJpaRepository, EncounterPersistenceMapper encounterPersistenceMapper) {
        return new EncounterRepositoryAdapter(encounterJpaRepository, encounterPersistenceMapper);
    }

    @Bean
    public RegisterEncounterUseCase registerEncounterUseCase(EncounterRepository encounterRepository) {
        return new RegisterEncounterUseCase(encounterRepository);
    }

    @Bean
    public GetEncounterByIdUseCase getEncounterByIdUseCase(EncounterRepository encounterRepository) {
        return new GetEncounterByIdUseCase(encounterRepository);
    }

    @Bean
    public ListEncounterUseCase listEncounterUseCase(EncounterRepository encounterRepository) {
        return new ListEncounterUseCase(encounterRepository);
    }

    @Bean
    public UpdateEncounterUseCase updateEncounterUseCase(EncounterRepository encounterRepository) {
        return new UpdateEncounterUseCase(encounterRepository);
    }

    @Bean
    public DeleteEncounterUseCase deleteEncounterUseCase(EncounterRepository encounterRepository) {
        return new DeleteEncounterUseCase(encounterRepository);
    }
}
