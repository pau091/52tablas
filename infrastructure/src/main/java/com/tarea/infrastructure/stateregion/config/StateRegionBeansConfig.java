package com.tarea.infrastructure.stateregion.config;

import com.tarea.application.stateregion.usecase.DeleteStateRegionUseCase;
import com.tarea.application.stateregion.usecase.GetStateRegionByIdUseCase;
import com.tarea.application.stateregion.usecase.ListStateRegionsUseCase;
import com.tarea.application.stateregion.usecase.RegisterStateRegionUseCase;
import com.tarea.application.stateregion.usecase.UpdateStateRegionUseCase;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionJpaRepository;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateRegionBeansConfig {

    @Bean
    public StateRegionPersistenceMapper stateRegionPersistenceMapper() {
        return new StateRegionPersistenceMapper();
    }

    @Bean
    public StateRegionRepository stateRegionRepository(StateRegionJpaRepository stateRegionJpaRepository, StateRegionPersistenceMapper stateRegionPersistenceMapper) {
        return new StateRegionRepositoryAdapter(stateRegionJpaRepository, stateRegionPersistenceMapper);
    }

    @Bean
    public RegisterStateRegionUseCase registerStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        return new RegisterStateRegionUseCase(stateRegionRepository);
    }

    @Bean
    public GetStateRegionByIdUseCase getStateRegionByIdUseCase(StateRegionRepository stateRegionRepository) {
        return new GetStateRegionByIdUseCase(stateRegionRepository);
    }

    @Bean
    public ListStateRegionsUseCase listStateRegionsUseCase(StateRegionRepository stateRegionRepository) {
        return new ListStateRegionsUseCase(stateRegionRepository);
    }

    @Bean
    public UpdateStateRegionUseCase updateStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        return new UpdateStateRegionUseCase(stateRegionRepository);
    }

    @Bean
    public DeleteStateRegionUseCase deleteStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        return new DeleteStateRegionUseCase(stateRegionRepository);
    }
}
