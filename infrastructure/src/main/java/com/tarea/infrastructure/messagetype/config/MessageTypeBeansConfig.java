package com.tarea.infrastructure.messagetype.config;

import com.tarea.application.messagetype.usecase.DeleteMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.GetMessageTypeByIdUseCase;
import com.tarea.application.messagetype.usecase.ListMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.RegisterMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.UpdateMessageTypeUseCase;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypePersistenceMapper;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories.MessageTypeJpaRepository;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories.MessageTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageTypeBeansConfig {

    @Bean
    public MessageTypePersistenceMapper messageTypePersistenceMapper() {
        return new MessageTypePersistenceMapper();
    }

    @Bean
    public MessageTypeRepository messageTypeRepository(MessageTypeJpaRepository messageTypeJpaRepository, MessageTypePersistenceMapper messageTypePersistenceMapper) {
        return new MessageTypeRepositoryAdapter(messageTypeJpaRepository, messageTypePersistenceMapper);
    }

    @Bean
    public RegisterMessageTypeUseCase registerMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        return new RegisterMessageTypeUseCase(messageTypeRepository);
    }

    @Bean
    public GetMessageTypeByIdUseCase getMessageTypeByIdUseCase(MessageTypeRepository messageTypeRepository) {
        return new GetMessageTypeByIdUseCase(messageTypeRepository);
    }

    @Bean
    public ListMessageTypeUseCase listMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        return new ListMessageTypeUseCase(messageTypeRepository);
    }

    @Bean
    public UpdateMessageTypeUseCase updateMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        return new UpdateMessageTypeUseCase(messageTypeRepository);
    }

    @Bean
    public DeleteMessageTypeUseCase deleteMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        return new DeleteMessageTypeUseCase(messageTypeRepository);
    }
}
