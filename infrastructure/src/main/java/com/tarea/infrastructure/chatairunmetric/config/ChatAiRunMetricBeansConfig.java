package com.tarea.infrastructure.chatairunmetric.config;

import com.tarea.application.chatairunmetric.usecase.DeleteChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.GetChatAiRunMetricByIdUseCase;
import com.tarea.application.chatairunmetric.usecase.ListChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.RegisterChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.UpdateChatAiRunMetricUseCase;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricPersistenceMapper;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricJpaRepository;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAiRunMetricBeansConfig {

    @Bean
    public ChatAiRunMetricPersistenceMapper chatAiRunMetricPersistenceMapper() {
        return new ChatAiRunMetricPersistenceMapper();
    }

    @Bean
    public ChatAiRunMetricRepository chatAiRunMetricRepository(ChatAiRunMetricJpaRepository chatAiRunMetricJpaRepository, ChatAiRunMetricPersistenceMapper chatAiRunMetricPersistenceMapper) {
        return new ChatAiRunMetricRepositoryAdapter(chatAiRunMetricJpaRepository, chatAiRunMetricPersistenceMapper);
    }

    @Bean
    public RegisterChatAiRunMetricUseCase registerChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        return new RegisterChatAiRunMetricUseCase(chatAiRunMetricRepository);
    }

    @Bean
    public GetChatAiRunMetricByIdUseCase getChatAiRunMetricByIdUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        return new GetChatAiRunMetricByIdUseCase(chatAiRunMetricRepository);
    }

    @Bean
    public ListChatAiRunMetricUseCase listChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        return new ListChatAiRunMetricUseCase(chatAiRunMetricRepository);
    }

    @Bean
    public UpdateChatAiRunMetricUseCase updateChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        return new UpdateChatAiRunMetricUseCase(chatAiRunMetricRepository);
    }

    @Bean
    public DeleteChatAiRunMetricUseCase deleteChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        return new DeleteChatAiRunMetricUseCase(chatAiRunMetricRepository);
    }
}
