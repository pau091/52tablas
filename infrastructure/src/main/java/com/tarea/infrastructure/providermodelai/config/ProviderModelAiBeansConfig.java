package com.tarea.infrastructure.providermodelai.config;

import com.tarea.application.providermodelai.usecase.DeleteProviderModelAiUseCase;
import com.tarea.application.providermodelai.usecase.GetProviderModelAiByIdUseCase;
import com.tarea.application.providermodelai.usecase.ListProviderModelAiUseCase;
import com.tarea.application.providermodelai.usecase.RegisterProviderModelAiUseCase;
import com.tarea.application.providermodelai.usecase.UpdateProviderModelAiUseCase;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.mappers.ProviderModelAiPersistenceMapper;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.repositories.ProviderModelAiJpaRepository;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.repositories.ProviderModelAiRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderModelAiBeansConfig {

    @Bean
    public ProviderModelAiPersistenceMapper providerModelAiPersistenceMapper() {
        return new ProviderModelAiPersistenceMapper();
    }

    @Bean
    public ProviderModelAiRepository providerModelAiRepository(ProviderModelAiJpaRepository providerModelAiJpaRepository, ProviderModelAiPersistenceMapper providerModelAiPersistenceMapper) {
        return new ProviderModelAiRepositoryAdapter(providerModelAiJpaRepository, providerModelAiPersistenceMapper);
    }

    @Bean
    public RegisterProviderModelAiUseCase registerProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        return new RegisterProviderModelAiUseCase(providerModelAiRepository);
    }

    @Bean
    public GetProviderModelAiByIdUseCase getProviderModelAiByIdUseCase(ProviderModelAiRepository providerModelAiRepository) {
        return new GetProviderModelAiByIdUseCase(providerModelAiRepository);
    }

    @Bean
    public ListProviderModelAiUseCase listProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        return new ListProviderModelAiUseCase(providerModelAiRepository);
    }

    @Bean
    public UpdateProviderModelAiUseCase updateProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        return new UpdateProviderModelAiUseCase(providerModelAiRepository);
    }

    @Bean
    public DeleteProviderModelAiUseCase deleteProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        return new DeleteProviderModelAiUseCase(providerModelAiRepository);
    }
}
