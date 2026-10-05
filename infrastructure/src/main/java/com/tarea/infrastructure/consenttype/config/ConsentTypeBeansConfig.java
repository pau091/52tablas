package com.tarea.infrastructure.consenttype.config;

import com.tarea.application.consenttype.usecase.DeleteConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.GetConsentTypeByIdUseCase;
import com.tarea.application.consenttype.usecase.ListConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.RegisterConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.UpdateConsentTypeUseCase;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeJpaRepository;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsentTypeBeansConfig {

    @Bean
    public ConsentTypePersistenceMapper consentTypePersistenceMapper() {
        return new ConsentTypePersistenceMapper();
    }

    @Bean
    public ConsentTypeRepository consentTypeRepository(ConsentTypeJpaRepository consentTypeJpaRepository, ConsentTypePersistenceMapper consentTypePersistenceMapper) {
        return new ConsentTypeRepositoryAdapter(consentTypeJpaRepository, consentTypePersistenceMapper);
    }

    @Bean
    public RegisterConsentTypeUseCase registerConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        return new RegisterConsentTypeUseCase(consentTypeRepository);
    }

    @Bean
    public GetConsentTypeByIdUseCase getConsentTypeByIdUseCase(ConsentTypeRepository consentTypeRepository) {
        return new GetConsentTypeByIdUseCase(consentTypeRepository);
    }

    @Bean
    public ListConsentTypeUseCase listConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        return new ListConsentTypeUseCase(consentTypeRepository);
    }

    @Bean
    public UpdateConsentTypeUseCase updateConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        return new UpdateConsentTypeUseCase(consentTypeRepository);
    }

    @Bean
    public DeleteConsentTypeUseCase deleteConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        return new DeleteConsentTypeUseCase(consentTypeRepository);
    }
}
