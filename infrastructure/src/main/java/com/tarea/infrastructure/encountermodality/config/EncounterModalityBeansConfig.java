package com.tarea.infrastructure.encountermodality.config;

import com.tarea.application.encountermodality.usecase.DeleteEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.GetEncounterModalityByIdUseCase;
import com.tarea.application.encountermodality.usecase.ListEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.RegisterEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.UpdateEncounterModalityUseCase;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityPersistenceMapper;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityJpaRepository;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterModalityBeansConfig {

    @Bean
    public EncounterModalityPersistenceMapper encounterModalityPersistenceMapper() {
        return new EncounterModalityPersistenceMapper();
    }

    @Bean
    public EncounterModalityRepository encounterModalityRepository(EncounterModalityJpaRepository encounterModalityJpaRepository, EncounterModalityPersistenceMapper encounterModalityPersistenceMapper) {
        return new EncounterModalityRepositoryAdapter(encounterModalityJpaRepository, encounterModalityPersistenceMapper);
    }

    @Bean
    public RegisterEncounterModalityUseCase registerEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        return new RegisterEncounterModalityUseCase(encounterModalityRepository);
    }

    @Bean
    public GetEncounterModalityByIdUseCase getEncounterModalityByIdUseCase(EncounterModalityRepository encounterModalityRepository) {
        return new GetEncounterModalityByIdUseCase(encounterModalityRepository);
    }

    @Bean
    public ListEncounterModalityUseCase listEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        return new ListEncounterModalityUseCase(encounterModalityRepository);
    }

    @Bean
    public UpdateEncounterModalityUseCase updateEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        return new UpdateEncounterModalityUseCase(encounterModalityRepository);
    }

    @Bean
    public DeleteEncounterModalityUseCase deleteEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        return new DeleteEncounterModalityUseCase(encounterModalityRepository);
    }
}
