package com.tarea.infrastructure.airunstatus.config;

import com.tarea.application.airunstatus.usecase.DeleteAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.GetAiRunStatusByIdUseCase;
import com.tarea.application.airunstatus.usecase.ListAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.RegisterAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.UpdateAiRunStatusUseCase;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusJpaRepository;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiRunStatusBeansConfig {

    @Bean
    public AiRunStatusPersistenceMapper aiRunStatusPersistenceMapper() {
        return new AiRunStatusPersistenceMapper();
    }

    @Bean
    public AiRunStatusRepository aiRunStatusRepository(AiRunStatusJpaRepository aiRunStatusJpaRepository, AiRunStatusPersistenceMapper aiRunStatusPersistenceMapper) {
        return new AiRunStatusRepositoryAdapter(aiRunStatusJpaRepository, aiRunStatusPersistenceMapper);
    }

    @Bean
    public RegisterAiRunStatusUseCase registerAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        return new RegisterAiRunStatusUseCase(aiRunStatusRepository);
    }

    @Bean
    public GetAiRunStatusByIdUseCase getAiRunStatusByIdUseCase(AiRunStatusRepository aiRunStatusRepository) {
        return new GetAiRunStatusByIdUseCase(aiRunStatusRepository);
    }

    @Bean
    public ListAiRunStatusUseCase listAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        return new ListAiRunStatusUseCase(aiRunStatusRepository);
    }

    @Bean
    public UpdateAiRunStatusUseCase updateAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        return new UpdateAiRunStatusUseCase(aiRunStatusRepository);
    }

    @Bean
    public DeleteAiRunStatusUseCase deleteAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        return new DeleteAiRunStatusUseCase(aiRunStatusRepository);
    }
}
