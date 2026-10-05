package com.tarea.infrastructure.chatescalation.config;

import com.tarea.application.chatescalation.usecase.DeleteChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.GetChatEscalationByIdUseCase;
import com.tarea.application.chatescalation.usecase.ListChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.RegisterChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.UpdateChatEscalationUseCase;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationPersistenceMapper;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationJpaRepository;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatEscalationBeansConfig {

    @Bean
    public ChatEscalationPersistenceMapper chatEscalationPersistenceMapper() {
        return new ChatEscalationPersistenceMapper();
    }

    @Bean
    public ChatEscalationRepository chatEscalationRepository(ChatEscalationJpaRepository chatEscalationJpaRepository, ChatEscalationPersistenceMapper chatEscalationPersistenceMapper) {
        return new ChatEscalationRepositoryAdapter(chatEscalationJpaRepository, chatEscalationPersistenceMapper);
    }

    @Bean
    public RegisterChatEscalationUseCase registerChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        return new RegisterChatEscalationUseCase(chatEscalationRepository);
    }

    @Bean
    public GetChatEscalationByIdUseCase getChatEscalationByIdUseCase(ChatEscalationRepository chatEscalationRepository) {
        return new GetChatEscalationByIdUseCase(chatEscalationRepository);
    }

    @Bean
    public ListChatEscalationUseCase listChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        return new ListChatEscalationUseCase(chatEscalationRepository);
    }

    @Bean
    public UpdateChatEscalationUseCase updateChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        return new UpdateChatEscalationUseCase(chatEscalationRepository);
    }

    @Bean
    public DeleteChatEscalationUseCase deleteChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        return new DeleteChatEscalationUseCase(chatEscalationRepository);
    }
}
