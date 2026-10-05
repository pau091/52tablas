package com.tarea.infrastructure.chatairunerror.config;

import com.tarea.application.chatairunerror.usecase.DeleteChatAiRunErrorUseCase;
import com.tarea.application.chatairunerror.usecase.GetChatAiRunErrorByIdUseCase;
import com.tarea.application.chatairunerror.usecase.ListChatAiRunErrorUseCase;
import com.tarea.application.chatairunerror.usecase.RegisterChatAiRunErrorUseCase;
import com.tarea.application.chatairunerror.usecase.UpdateChatAiRunErrorUseCase;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;
import com.tarea.infrastructure.chatairunerror.adapters.out.persistence.mappers.ChatAiRunErrorPersistenceMapper;
import com.tarea.infrastructure.chatairunerror.adapters.out.persistence.repositories.ChatAiRunErrorJpaRepository;
import com.tarea.infrastructure.chatairunerror.adapters.out.persistence.repositories.ChatAiRunErrorRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAiRunErrorBeansConfig {

    @Bean
    public ChatAiRunErrorPersistenceMapper chatAiRunErrorPersistenceMapper() {
        return new ChatAiRunErrorPersistenceMapper();
    }

    @Bean
    public ChatAiRunErrorRepository chatAiRunErrorRepository(ChatAiRunErrorJpaRepository chatAiRunErrorJpaRepository, ChatAiRunErrorPersistenceMapper chatAiRunErrorPersistenceMapper) {
        return new ChatAiRunErrorRepositoryAdapter(chatAiRunErrorJpaRepository, chatAiRunErrorPersistenceMapper);
    }

    @Bean
    public RegisterChatAiRunErrorUseCase registerChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        return new RegisterChatAiRunErrorUseCase(chatAiRunErrorRepository);
    }

    @Bean
    public GetChatAiRunErrorByIdUseCase getChatAiRunErrorByIdUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        return new GetChatAiRunErrorByIdUseCase(chatAiRunErrorRepository);
    }

    @Bean
    public ListChatAiRunErrorUseCase listChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        return new ListChatAiRunErrorUseCase(chatAiRunErrorRepository);
    }

    @Bean
    public UpdateChatAiRunErrorUseCase updateChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        return new UpdateChatAiRunErrorUseCase(chatAiRunErrorRepository);
    }

    @Bean
    public DeleteChatAiRunErrorUseCase deleteChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        return new DeleteChatAiRunErrorUseCase(chatAiRunErrorRepository);
    }
}
