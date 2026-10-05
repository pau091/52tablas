package com.tarea.infrastructure.sendertype.config;

import com.tarea.application.sendertype.usecase.DeleteSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.GetSenderTypeByIdUseCase;
import com.tarea.application.sendertype.usecase.ListSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.RegisterSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.UpdateSenderTypeUseCase;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypePersistenceMapper;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories.SenderTypeJpaRepository;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories.SenderTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderTypeBeansConfig {

    @Bean
    public SenderTypePersistenceMapper senderTypePersistenceMapper() {
        return new SenderTypePersistenceMapper();
    }

    @Bean
    public SenderTypeRepository senderTypeRepository(SenderTypeJpaRepository senderTypeJpaRepository, SenderTypePersistenceMapper senderTypePersistenceMapper) {
        return new SenderTypeRepositoryAdapter(senderTypeJpaRepository, senderTypePersistenceMapper);
    }

    @Bean
    public RegisterSenderTypeUseCase registerSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        return new RegisterSenderTypeUseCase(senderTypeRepository);
    }

    @Bean
    public GetSenderTypeByIdUseCase getSenderTypeByIdUseCase(SenderTypeRepository senderTypeRepository) {
        return new GetSenderTypeByIdUseCase(senderTypeRepository);
    }

    @Bean
    public ListSenderTypeUseCase listSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        return new ListSenderTypeUseCase(senderTypeRepository);
    }

    @Bean
    public UpdateSenderTypeUseCase updateSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        return new UpdateSenderTypeUseCase(senderTypeRepository);
    }

    @Bean
    public DeleteSenderTypeUseCase deleteSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        return new DeleteSenderTypeUseCase(senderTypeRepository);
    }
}
