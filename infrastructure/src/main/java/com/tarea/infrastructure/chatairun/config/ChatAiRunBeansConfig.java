package com.tarea.infrastructure.chatairun.config;

import com.tarea.application.chatairun.usecase.DeleteChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.GetChatAiRunByIdUseCase;
import com.tarea.application.chatairun.usecase.ListChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.RegisterChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.UpdateChatAiRunUseCase;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunJpaRepository;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAiRunBeansConfig {

    @Bean
    public ChatAiRunPersistenceMapper chatAiRunPersistenceMapper() {
        return new ChatAiRunPersistenceMapper();
    }

    @Bean
    public ChatAiRunRepository chatAiRunRepository(ChatAiRunJpaRepository chatAiRunJpaRepository, ChatAiRunPersistenceMapper chatAiRunPersistenceMapper) {
        return new ChatAiRunRepositoryAdapter(chatAiRunJpaRepository, chatAiRunPersistenceMapper);
    }

    @Bean
    public RegisterChatAiRunUseCase registerChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        return new RegisterChatAiRunUseCase(chatAiRunRepository);
    }

    @Bean
    public GetChatAiRunByIdUseCase getChatAiRunByIdUseCase(ChatAiRunRepository chatAiRunRepository) {
        return new GetChatAiRunByIdUseCase(chatAiRunRepository);
    }

    @Bean
    public ListChatAiRunUseCase listChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        return new ListChatAiRunUseCase(chatAiRunRepository);
    }

    @Bean
    public UpdateChatAiRunUseCase updateChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        return new UpdateChatAiRunUseCase(chatAiRunRepository);
    }

    @Bean
    public DeleteChatAiRunUseCase deleteChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        return new DeleteChatAiRunUseCase(chatAiRunRepository);
    }
}
