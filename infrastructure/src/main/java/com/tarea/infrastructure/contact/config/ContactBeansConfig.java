package com.tarea.infrastructure.contact.config;

import com.tarea.application.contact.usecase.DeleteContactUseCase;
import com.tarea.application.contact.usecase.GetContactByIdUseCase;
import com.tarea.application.contact.usecase.ListContactUseCase;
import com.tarea.application.contact.usecase.RegisterContactUseCase;
import com.tarea.application.contact.usecase.UpdateContactUseCase;
import com.tarea.domain.contact.port.repository.ContactRepository;
import com.tarea.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;
import com.tarea.infrastructure.contact.adapters.out.persistence.repositories.ContactJpaRepository;
import com.tarea.infrastructure.contact.adapters.out.persistence.repositories.ContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactBeansConfig {

    @Bean
    public ContactPersistenceMapper contactPersistenceMapper() {
        return new ContactPersistenceMapper();
    }

    @Bean
    public ContactRepository contactRepository(ContactJpaRepository contactJpaRepository, ContactPersistenceMapper contactPersistenceMapper) {
        return new ContactRepositoryAdapter(contactJpaRepository, contactPersistenceMapper);
    }

    @Bean
    public RegisterContactUseCase registerContactUseCase(ContactRepository contactRepository) {
        return new RegisterContactUseCase(contactRepository);
    }

    @Bean
    public GetContactByIdUseCase getContactByIdUseCase(ContactRepository contactRepository) {
        return new GetContactByIdUseCase(contactRepository);
    }

    @Bean
    public ListContactUseCase listContactUseCase(ContactRepository contactRepository) {
        return new ListContactUseCase(contactRepository);
    }

    @Bean
    public UpdateContactUseCase updateContactUseCase(ContactRepository contactRepository) {
        return new UpdateContactUseCase(contactRepository);
    }

    @Bean
    public DeleteContactUseCase deleteContactUseCase(ContactRepository contactRepository) {
        return new DeleteContactUseCase(contactRepository);
    }
}
