package com.tarea.infrastructure.emailcontact.config;

import com.tarea.application.emailcontact.usecase.DeleteEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.GetEmailContactByIdUseCase;
import com.tarea.application.emailcontact.usecase.ListEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.RegisterEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.UpdateEmailContactUseCase;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactJpaRepository;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailContactBeansConfig {

    @Bean
    public EmailContactPersistenceMapper emailContactPersistenceMapper() {
        return new EmailContactPersistenceMapper();
    }

    @Bean
    public EmailContactRepository emailContactRepository(EmailContactJpaRepository emailContactJpaRepository, EmailContactPersistenceMapper emailContactPersistenceMapper) {
        return new EmailContactRepositoryAdapter(emailContactJpaRepository, emailContactPersistenceMapper);
    }

    @Bean
    public RegisterEmailContactUseCase registerEmailContactUseCase(EmailContactRepository emailContactRepository) {
        return new RegisterEmailContactUseCase(emailContactRepository);
    }

    @Bean
    public GetEmailContactByIdUseCase getEmailContactByIdUseCase(EmailContactRepository emailContactRepository) {
        return new GetEmailContactByIdUseCase(emailContactRepository);
    }

    @Bean
    public ListEmailContactUseCase listEmailContactUseCase(EmailContactRepository emailContactRepository) {
        return new ListEmailContactUseCase(emailContactRepository);
    }

    @Bean
    public UpdateEmailContactUseCase updateEmailContactUseCase(EmailContactRepository emailContactRepository) {
        return new UpdateEmailContactUseCase(emailContactRepository);
    }

    @Bean
    public DeleteEmailContactUseCase deleteEmailContactUseCase(EmailContactRepository emailContactRepository) {
        return new DeleteEmailContactUseCase(emailContactRepository);
    }
}
