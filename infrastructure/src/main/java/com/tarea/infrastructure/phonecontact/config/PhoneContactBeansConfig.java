package com.tarea.infrastructure.phonecontact.config;

import com.tarea.application.phonecontact.usecase.DeletePhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.GetPhoneContactByIdUseCase;
import com.tarea.application.phonecontact.usecase.ListPhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.RegisterPhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.UpdatePhoneContactUseCase;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactJpaRepository;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneContactBeansConfig {

    @Bean
    public PhoneContactPersistenceMapper phoneContactPersistenceMapper() {
        return new PhoneContactPersistenceMapper();
    }

    @Bean
    public PhoneContactRepository phoneContactRepository(PhoneContactJpaRepository phoneContactJpaRepository, PhoneContactPersistenceMapper phoneContactPersistenceMapper) {
        return new PhoneContactRepositoryAdapter(phoneContactJpaRepository, phoneContactPersistenceMapper);
    }

    @Bean
    public RegisterPhoneContactUseCase registerPhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        return new RegisterPhoneContactUseCase(phoneContactRepository);
    }

    @Bean
    public GetPhoneContactByIdUseCase getPhoneContactByIdUseCase(PhoneContactRepository phoneContactRepository) {
        return new GetPhoneContactByIdUseCase(phoneContactRepository);
    }

    @Bean
    public ListPhoneContactUseCase listPhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        return new ListPhoneContactUseCase(phoneContactRepository);
    }

    @Bean
    public UpdatePhoneContactUseCase updatePhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        return new UpdatePhoneContactUseCase(phoneContactRepository);
    }

    @Bean
    public DeletePhoneContactUseCase deletePhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        return new DeletePhoneContactUseCase(phoneContactRepository);
    }
}
