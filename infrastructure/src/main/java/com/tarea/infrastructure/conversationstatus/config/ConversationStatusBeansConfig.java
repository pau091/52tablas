package com.tarea.infrastructure.conversationstatus.config;

import com.tarea.application.conversationstatus.usecase.DeleteConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.GetConversationStatusByIdUseCase;
import com.tarea.application.conversationstatus.usecase.ListConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.RegisterConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.UpdateConversationStatusUseCase;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusJpaRepository;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversationStatusBeansConfig {

    @Bean
    public ConversationStatusPersistenceMapper conversationStatusPersistenceMapper() {
        return new ConversationStatusPersistenceMapper();
    }

    @Bean
    public ConversationStatusRepository conversationStatusRepository(ConversationStatusJpaRepository conversationStatusJpaRepository, ConversationStatusPersistenceMapper conversationStatusPersistenceMapper) {
        return new ConversationStatusRepositoryAdapter(conversationStatusJpaRepository, conversationStatusPersistenceMapper);
    }

    @Bean
    public RegisterConversationStatusUseCase registerConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        return new RegisterConversationStatusUseCase(conversationStatusRepository);
    }

    @Bean
    public GetConversationStatusByIdUseCase getConversationStatusByIdUseCase(ConversationStatusRepository conversationStatusRepository) {
        return new GetConversationStatusByIdUseCase(conversationStatusRepository);
    }

    @Bean
    public ListConversationStatusUseCase listConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        return new ListConversationStatusUseCase(conversationStatusRepository);
    }

    @Bean
    public UpdateConversationStatusUseCase updateConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        return new UpdateConversationStatusUseCase(conversationStatusRepository);
    }

    @Bean
    public DeleteConversationStatusUseCase deleteConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        return new DeleteConversationStatusUseCase(conversationStatusRepository);
    }
}
