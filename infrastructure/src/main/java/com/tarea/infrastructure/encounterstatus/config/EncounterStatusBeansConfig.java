package com.tarea.infrastructure.encounterstatus.config;

import com.tarea.application.encounterstatus.usecase.DeleteEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.GetEncounterStatusByIdUseCase;
import com.tarea.application.encounterstatus.usecase.ListEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.RegisterEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.UpdateEncounterStatusUseCase;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusJpaRepository;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterStatusBeansConfig {

    @Bean
    public EncounterStatusPersistenceMapper encounterStatusPersistenceMapper() {
        return new EncounterStatusPersistenceMapper();
    }

    @Bean
    public EncounterStatusRepository encounterStatusRepository(EncounterStatusJpaRepository encounterStatusJpaRepository, EncounterStatusPersistenceMapper encounterStatusPersistenceMapper) {
        return new EncounterStatusRepositoryAdapter(encounterStatusJpaRepository, encounterStatusPersistenceMapper);
    }

    @Bean
    public RegisterEncounterStatusUseCase registerEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        return new RegisterEncounterStatusUseCase(encounterStatusRepository);
    }

    @Bean
    public GetEncounterStatusByIdUseCase getEncounterStatusByIdUseCase(EncounterStatusRepository encounterStatusRepository) {
        return new GetEncounterStatusByIdUseCase(encounterStatusRepository);
    }

    @Bean
    public ListEncounterStatusUseCase listEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        return new ListEncounterStatusUseCase(encounterStatusRepository);
    }

    @Bean
    public UpdateEncounterStatusUseCase updateEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        return new UpdateEncounterStatusUseCase(encounterStatusRepository);
    }

    @Bean
    public DeleteEncounterStatusUseCase deleteEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        return new DeleteEncounterStatusUseCase(encounterStatusRepository);
    }
}
