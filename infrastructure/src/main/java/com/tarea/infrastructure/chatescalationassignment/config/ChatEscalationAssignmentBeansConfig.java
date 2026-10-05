package com.tarea.infrastructure.chatescalationassignment.config;

import com.tarea.application.chatescalationassignment.usecase.DeleteChatEscalationAssignmentUseCase;
import com.tarea.application.chatescalationassignment.usecase.GetChatEscalationAssignmentByIdUseCase;
import com.tarea.application.chatescalationassignment.usecase.ListChatEscalationAssignmentUseCase;
import com.tarea.application.chatescalationassignment.usecase.RegisterChatEscalationAssignmentUseCase;
import com.tarea.application.chatescalationassignment.usecase.UpdateChatEscalationAssignmentUseCase;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.tarea.infrastructure.chatescalationassignment.adapters.out.persistence.mappers.ChatEscalationAssignmentPersistenceMapper;
import com.tarea.infrastructure.chatescalationassignment.adapters.out.persistence.repositories.ChatEscalationAssignmentJpaRepository;
import com.tarea.infrastructure.chatescalationassignment.adapters.out.persistence.repositories.ChatEscalationAssignmentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatEscalationAssignmentBeansConfig {

    @Bean
    public ChatEscalationAssignmentPersistenceMapper chatEscalationAssignmentPersistenceMapper() {
        return new ChatEscalationAssignmentPersistenceMapper();
    }

    @Bean
    public ChatEscalationAssignmentRepository chatEscalationAssignmentRepository(ChatEscalationAssignmentJpaRepository chatEscalationAssignmentJpaRepository, ChatEscalationAssignmentPersistenceMapper chatEscalationAssignmentPersistenceMapper) {
        return new ChatEscalationAssignmentRepositoryAdapter(chatEscalationAssignmentJpaRepository, chatEscalationAssignmentPersistenceMapper);
    }

    @Bean
    public RegisterChatEscalationAssignmentUseCase registerChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        return new RegisterChatEscalationAssignmentUseCase(chatEscalationAssignmentRepository);
    }

    @Bean
    public GetChatEscalationAssignmentByIdUseCase getChatEscalationAssignmentByIdUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        return new GetChatEscalationAssignmentByIdUseCase(chatEscalationAssignmentRepository);
    }

    @Bean
    public ListChatEscalationAssignmentUseCase listChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        return new ListChatEscalationAssignmentUseCase(chatEscalationAssignmentRepository);
    }

    @Bean
    public UpdateChatEscalationAssignmentUseCase updateChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        return new UpdateChatEscalationAssignmentUseCase(chatEscalationAssignmentRepository);
    }

    @Bean
    public DeleteChatEscalationAssignmentUseCase deleteChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        return new DeleteChatEscalationAssignmentUseCase(chatEscalationAssignmentRepository);
    }
}
