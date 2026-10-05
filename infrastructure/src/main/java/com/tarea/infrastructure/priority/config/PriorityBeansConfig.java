package com.tarea.infrastructure.priority.config;

import com.tarea.application.priority.usecase.DeletePriorityUseCase;
import com.tarea.application.priority.usecase.GetPriorityByIdUseCase;
import com.tarea.application.priority.usecase.ListPriorityUseCase;
import com.tarea.application.priority.usecase.RegisterPriorityUseCase;
import com.tarea.application.priority.usecase.UpdatePriorityUseCase;
import com.tarea.domain.priority.port.repository.PriorityRepository;
import com.tarea.infrastructure.priority.adapters.out.persistence.mappers.PriorityPersistenceMapper;
import com.tarea.infrastructure.priority.adapters.out.persistence.repositories.PriorityJpaRepository;
import com.tarea.infrastructure.priority.adapters.out.persistence.repositories.PriorityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriorityBeansConfig {

    @Bean
    public PriorityPersistenceMapper priorityPersistenceMapper() {
        return new PriorityPersistenceMapper();
    }

    @Bean
    public PriorityRepository priorityRepository(PriorityJpaRepository priorityJpaRepository, PriorityPersistenceMapper priorityPersistenceMapper) {
        return new PriorityRepositoryAdapter(priorityJpaRepository, priorityPersistenceMapper);
    }

    @Bean
    public RegisterPriorityUseCase registerPriorityUseCase(PriorityRepository priorityRepository) {
        return new RegisterPriorityUseCase(priorityRepository);
    }

    @Bean
    public GetPriorityByIdUseCase getPriorityByIdUseCase(PriorityRepository priorityRepository) {
        return new GetPriorityByIdUseCase(priorityRepository);
    }

    @Bean
    public ListPriorityUseCase listPriorityUseCase(PriorityRepository priorityRepository) {
        return new ListPriorityUseCase(priorityRepository);
    }

    @Bean
    public UpdatePriorityUseCase updatePriorityUseCase(PriorityRepository priorityRepository) {
        return new UpdatePriorityUseCase(priorityRepository);
    }

    @Bean
    public DeletePriorityUseCase deletePriorityUseCase(PriorityRepository priorityRepository) {
        return new DeletePriorityUseCase(priorityRepository);
    }
}
