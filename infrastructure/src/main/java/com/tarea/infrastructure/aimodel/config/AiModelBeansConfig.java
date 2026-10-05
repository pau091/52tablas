package com.tarea.infrastructure.aimodel.config;

import com.tarea.application.aimodel.usecase.DeleteAiModelUseCase;
import com.tarea.application.aimodel.usecase.GetAiModelByIdUseCase;
import com.tarea.application.aimodel.usecase.ListAiModelUseCase;
import com.tarea.application.aimodel.usecase.RegisterAiModelUseCase;
import com.tarea.application.aimodel.usecase.UpdateAiModelUseCase;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelJpaRepository;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiModelBeansConfig {

    @Bean
    public AiModelPersistenceMapper aiModelPersistenceMapper() {
        return new AiModelPersistenceMapper();
    }

    @Bean
    public AiModelRepository aiModelRepository(AiModelJpaRepository aiModelJpaRepository, AiModelPersistenceMapper aiModelPersistenceMapper) {
        return new AiModelRepositoryAdapter(aiModelJpaRepository, aiModelPersistenceMapper);
    }

    @Bean
    public RegisterAiModelUseCase registerAiModelUseCase(AiModelRepository aiModelRepository) {
        return new RegisterAiModelUseCase(aiModelRepository);
    }

    @Bean
    public GetAiModelByIdUseCase getAiModelByIdUseCase(AiModelRepository aiModelRepository) {
        return new GetAiModelByIdUseCase(aiModelRepository);
    }

    @Bean
    public ListAiModelUseCase listAiModelUseCase(AiModelRepository aiModelRepository) {
        return new ListAiModelUseCase(aiModelRepository);
    }

    @Bean
    public UpdateAiModelUseCase updateAiModelUseCase(AiModelRepository aiModelRepository) {
        return new UpdateAiModelUseCase(aiModelRepository);
    }

    @Bean
    public DeleteAiModelUseCase deleteAiModelUseCase(AiModelRepository aiModelRepository) {
        return new DeleteAiModelUseCase(aiModelRepository);
    }
}
