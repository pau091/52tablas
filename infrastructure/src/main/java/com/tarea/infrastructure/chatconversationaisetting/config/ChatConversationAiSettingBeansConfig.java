package com.tarea.infrastructure.chatconversationaisetting.config;

import com.tarea.application.chatconversationaisetting.usecase.DeleteChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.GetChatConversationAiSettingByIdUseCase;
import com.tarea.application.chatconversationaisetting.usecase.ListChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.RegisterChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.UpdateChatConversationAiSettingUseCase;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatConversationAiSettingPersistenceMapper;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingJpaRepository;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConversationAiSettingBeansConfig {

    @Bean
    public ChatConversationAiSettingPersistenceMapper chatConversationAiSettingPersistenceMapper() {
        return new ChatConversationAiSettingPersistenceMapper();
    }

    @Bean
    public ChatConversationAiSettingRepository chatConversationAiSettingRepository(ChatConversationAiSettingJpaRepository chatConversationAiSettingJpaRepository, ChatConversationAiSettingPersistenceMapper chatConversationAiSettingPersistenceMapper) {
        return new ChatConversationAiSettingRepositoryAdapter(chatConversationAiSettingJpaRepository, chatConversationAiSettingPersistenceMapper);
    }

    @Bean
    public RegisterChatConversationAiSettingUseCase registerChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        return new RegisterChatConversationAiSettingUseCase(chatConversationAiSettingRepository);
    }

    @Bean
    public GetChatConversationAiSettingByIdUseCase getChatConversationAiSettingByIdUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        return new GetChatConversationAiSettingByIdUseCase(chatConversationAiSettingRepository);
    }

    @Bean
    public ListChatConversationAiSettingUseCase listChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        return new ListChatConversationAiSettingUseCase(chatConversationAiSettingRepository);
    }

    @Bean
    public UpdateChatConversationAiSettingUseCase updateChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        return new UpdateChatConversationAiSettingUseCase(chatConversationAiSettingRepository);
    }

    @Bean
    public DeleteChatConversationAiSettingUseCase deleteChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        return new DeleteChatConversationAiSettingUseCase(chatConversationAiSettingRepository);
    }
}
