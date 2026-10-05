package com.tarea.infrastructure.chatmessage.config;

import com.tarea.application.chatmessage.usecase.DeleteChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.GetChatMessageByIdUseCase;
import com.tarea.application.chatmessage.usecase.ListChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.RegisterChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.UpdateChatMessageUseCase;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageJpaRepository;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMessageBeansConfig {

    @Bean
    public ChatMessagePersistenceMapper chatMessagePersistenceMapper() {
        return new ChatMessagePersistenceMapper();
    }

    @Bean
    public ChatMessageRepository chatMessageRepository(ChatMessageJpaRepository chatMessageJpaRepository, ChatMessagePersistenceMapper chatMessagePersistenceMapper) {
        return new ChatMessageRepositoryAdapter(chatMessageJpaRepository, chatMessagePersistenceMapper);
    }

    @Bean
    public RegisterChatMessageUseCase registerChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        return new RegisterChatMessageUseCase(chatMessageRepository);
    }

    @Bean
    public GetChatMessageByIdUseCase getChatMessageByIdUseCase(ChatMessageRepository chatMessageRepository) {
        return new GetChatMessageByIdUseCase(chatMessageRepository);
    }

    @Bean
    public ListChatMessageUseCase listChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        return new ListChatMessageUseCase(chatMessageRepository);
    }

    @Bean
    public UpdateChatMessageUseCase updateChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        return new UpdateChatMessageUseCase(chatMessageRepository);
    }

    @Bean
    public DeleteChatMessageUseCase deleteChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        return new DeleteChatMessageUseCase(chatMessageRepository);
    }
}
