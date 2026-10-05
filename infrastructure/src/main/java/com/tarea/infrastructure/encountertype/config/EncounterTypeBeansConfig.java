package com.tarea.infrastructure.encountertype.config;

import com.tarea.application.encountertype.usecase.DeleteEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.GetEncounterTypeByIdUseCase;
import com.tarea.application.encountertype.usecase.ListEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.RegisterEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.UpdateEncounterTypeUseCase;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypePersistenceMapper;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories.EncounterTypeJpaRepository;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories.EncounterTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterTypeBeansConfig {

    @Bean
    public EncounterTypePersistenceMapper encounterTypePersistenceMapper() {
        return new EncounterTypePersistenceMapper();
    }

    @Bean
    public EncounterTypeRepository encounterTypeRepository(EncounterTypeJpaRepository encounterTypeJpaRepository, EncounterTypePersistenceMapper encounterTypePersistenceMapper) {
        return new EncounterTypeRepositoryAdapter(encounterTypeJpaRepository, encounterTypePersistenceMapper);
    }

    @Bean
    public RegisterEncounterTypeUseCase registerEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        return new RegisterEncounterTypeUseCase(encounterTypeRepository);
    }

    @Bean
    public GetEncounterTypeByIdUseCase getEncounterTypeByIdUseCase(EncounterTypeRepository encounterTypeRepository) {
        return new GetEncounterTypeByIdUseCase(encounterTypeRepository);
    }

    @Bean
    public ListEncounterTypeUseCase listEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        return new ListEncounterTypeUseCase(encounterTypeRepository);
    }

    @Bean
    public UpdateEncounterTypeUseCase updateEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        return new UpdateEncounterTypeUseCase(encounterTypeRepository);
    }

    @Bean
    public DeleteEncounterTypeUseCase deleteEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        return new DeleteEncounterTypeUseCase(encounterTypeRepository);
    }
}
