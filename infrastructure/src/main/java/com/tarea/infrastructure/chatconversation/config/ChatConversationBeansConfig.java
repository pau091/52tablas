package com.tarea.infrastructure.chatconversation.config;

import com.tarea.application.chatconversation.usecase.DeleteChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.GetChatConversationByIdUseCase;
import com.tarea.application.chatconversation.usecase.ListChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.RegisterChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.UpdateChatConversationUseCase;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationPersistenceMapper;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationJpaRepository;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConversationBeansConfig {

    @Bean
    public ChatConversationPersistenceMapper chatConversationPersistenceMapper() {
        return new ChatConversationPersistenceMapper();
    }

    @Bean
    public ChatConversationRepository chatConversationRepository(ChatConversationJpaRepository chatConversationJpaRepository, ChatConversationPersistenceMapper chatConversationPersistenceMapper) {
        return new ChatConversationRepositoryAdapter(chatConversationJpaRepository, chatConversationPersistenceMapper);
    }

    @Bean
    public RegisterChatConversationUseCase registerChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        return new RegisterChatConversationUseCase(chatConversationRepository);
    }

    @Bean
    public GetChatConversationByIdUseCase getChatConversationByIdUseCase(ChatConversationRepository chatConversationRepository) {
        return new GetChatConversationByIdUseCase(chatConversationRepository);
    }

    @Bean
    public ListChatConversationUseCase listChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        return new ListChatConversationUseCase(chatConversationRepository);
    }

    @Bean
    public UpdateChatConversationUseCase updateChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        return new UpdateChatConversationUseCase(chatConversationRepository);
    }

    @Bean
    public DeleteChatConversationUseCase deleteChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        return new DeleteChatConversationUseCase(chatConversationRepository);
    }
}
