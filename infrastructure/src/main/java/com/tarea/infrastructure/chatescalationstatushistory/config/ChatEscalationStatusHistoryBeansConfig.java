package com.tarea.infrastructure.chatescalationstatushistory.config;

import com.tarea.application.chatescalationstatushistory.usecase.DeleteChatEscalationStatusHistoryUseCase;
import com.tarea.application.chatescalationstatushistory.usecase.GetChatEscalationStatusHistoryByIdUseCase;
import com.tarea.application.chatescalationstatushistory.usecase.ListChatEscalationStatusHistoryUseCase;
import com.tarea.application.chatescalationstatushistory.usecase.RegisterChatEscalationStatusHistoryUseCase;
import com.tarea.application.chatescalationstatushistory.usecase.UpdateChatEscalationStatusHistoryUseCase;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers.ChatEscalationStatusHistoryPersistenceMapper;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories.ChatEscalationStatusHistoryJpaRepository;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories.ChatEscalationStatusHistoryRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatEscalationStatusHistoryBeansConfig {

    @Bean
    public ChatEscalationStatusHistoryPersistenceMapper chatEscalationStatusHistoryPersistenceMapper() {
        return new ChatEscalationStatusHistoryPersistenceMapper();
    }

    @Bean
    public ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository(ChatEscalationStatusHistoryJpaRepository chatEscalationStatusHistoryJpaRepository, ChatEscalationStatusHistoryPersistenceMapper chatEscalationStatusHistoryPersistenceMapper) {
        return new ChatEscalationStatusHistoryRepositoryAdapter(chatEscalationStatusHistoryJpaRepository, chatEscalationStatusHistoryPersistenceMapper);
    }

    @Bean
    public RegisterChatEscalationStatusHistoryUseCase registerChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        return new RegisterChatEscalationStatusHistoryUseCase(chatEscalationStatusHistoryRepository);
    }

    @Bean
    public GetChatEscalationStatusHistoryByIdUseCase getChatEscalationStatusHistoryByIdUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        return new GetChatEscalationStatusHistoryByIdUseCase(chatEscalationStatusHistoryRepository);
    }

    @Bean
    public ListChatEscalationStatusHistoryUseCase listChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        return new ListChatEscalationStatusHistoryUseCase(chatEscalationStatusHistoryRepository);
    }

    @Bean
    public UpdateChatEscalationStatusHistoryUseCase updateChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        return new UpdateChatEscalationStatusHistoryUseCase(chatEscalationStatusHistoryRepository);
    }

    @Bean
    public DeleteChatEscalationStatusHistoryUseCase deleteChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        return new DeleteChatEscalationStatusHistoryUseCase(chatEscalationStatusHistoryRepository);
    }
}
