package com.tarea.infrastructure.chatparticipant.config;

import com.tarea.application.chatparticipant.usecase.DeleteChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.GetChatParticipantByIdUseCase;
import com.tarea.application.chatparticipant.usecase.ListChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.RegisterChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.UpdateChatParticipantUseCase;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantJpaRepository;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatParticipantBeansConfig {

    @Bean
    public ChatParticipantPersistenceMapper chatParticipantPersistenceMapper() {
        return new ChatParticipantPersistenceMapper();
    }

    @Bean
    public ChatParticipantRepository chatParticipantRepository(ChatParticipantJpaRepository chatParticipantJpaRepository, ChatParticipantPersistenceMapper chatParticipantPersistenceMapper) {
        return new ChatParticipantRepositoryAdapter(chatParticipantJpaRepository, chatParticipantPersistenceMapper);
    }

    @Bean
    public RegisterChatParticipantUseCase registerChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        return new RegisterChatParticipantUseCase(chatParticipantRepository);
    }

    @Bean
    public GetChatParticipantByIdUseCase getChatParticipantByIdUseCase(ChatParticipantRepository chatParticipantRepository) {
        return new GetChatParticipantByIdUseCase(chatParticipantRepository);
    }

    @Bean
    public ListChatParticipantUseCase listChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        return new ListChatParticipantUseCase(chatParticipantRepository);
    }

    @Bean
    public UpdateChatParticipantUseCase updateChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        return new UpdateChatParticipantUseCase(chatParticipantRepository);
    }

    @Bean
    public DeleteChatParticipantUseCase deleteChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        return new DeleteChatParticipantUseCase(chatParticipantRepository);
    }
}
