package com.tarea.infrastructure.escalationstatus.config;

import com.tarea.application.escalationstatus.usecase.DeleteEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.GetEscalationStatusByIdUseCase;
import com.tarea.application.escalationstatus.usecase.ListEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.RegisterEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.UpdateEscalationStatusUseCase;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.mappers.EscalationStatusPersistenceMapper;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories.EscalationStatusJpaRepository;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories.EscalationStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscalationStatusBeansConfig {

    @Bean
    public EscalationStatusPersistenceMapper escalationStatusPersistenceMapper() {
        return new EscalationStatusPersistenceMapper();
    }

    @Bean
    public EscalationStatusRepository escalationStatusRepository(EscalationStatusJpaRepository escalationStatusJpaRepository, EscalationStatusPersistenceMapper escalationStatusPersistenceMapper) {
        return new EscalationStatusRepositoryAdapter(escalationStatusJpaRepository, escalationStatusPersistenceMapper);
    }

    @Bean
    public RegisterEscalationStatusUseCase registerEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        return new RegisterEscalationStatusUseCase(escalationStatusRepository);
    }

    @Bean
    public GetEscalationStatusByIdUseCase getEscalationStatusByIdUseCase(EscalationStatusRepository escalationStatusRepository) {
        return new GetEscalationStatusByIdUseCase(escalationStatusRepository);
    }

    @Bean
    public ListEscalationStatusUseCase listEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        return new ListEscalationStatusUseCase(escalationStatusRepository);
    }

    @Bean
    public UpdateEscalationStatusUseCase updateEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        return new UpdateEscalationStatusUseCase(escalationStatusRepository);
    }

    @Bean
    public DeleteEscalationStatusUseCase deleteEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        return new DeleteEscalationStatusUseCase(escalationStatusRepository);
    }
}
