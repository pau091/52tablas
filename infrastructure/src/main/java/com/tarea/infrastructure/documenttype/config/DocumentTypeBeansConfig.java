package com.tarea.infrastructure.documenttype.config;

import com.tarea.application.documenttype.usecase.DeleteDocumentTypeUseCase;
import com.tarea.application.documenttype.usecase.GetDocumentTypeByIdUseCase;
import com.tarea.application.documenttype.usecase.ListDocumentTypesUseCase;
import com.tarea.application.documenttype.usecase.RegisterDocumentTypeUseCase;
import com.tarea.application.documenttype.usecase.UpdateDocumentTypeUseCase;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.mappers.DocumentTypePersistenceMapper;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories.DocumentTypeJpaRepository;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories.DocumentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentTypeBeansConfig {

    @Bean
    public DocumentTypePersistenceMapper documentTypePersistenceMapper() {
        return new DocumentTypePersistenceMapper();
    }

    @Bean
    public DocumentTypeRepository documentTypeRepository(DocumentTypeJpaRepository documentTypeJpaRepository, DocumentTypePersistenceMapper documentTypePersistenceMapper) {
        return new DocumentTypeRepositoryAdapter(documentTypeJpaRepository, documentTypePersistenceMapper);
    }

    @Bean
    public RegisterDocumentTypeUseCase registerDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        return new RegisterDocumentTypeUseCase(documentTypeRepository);
    }

    @Bean
    public GetDocumentTypeByIdUseCase getDocumentTypeByIdUseCase(DocumentTypeRepository documentTypeRepository) {
        return new GetDocumentTypeByIdUseCase(documentTypeRepository);
    }

    @Bean
    public ListDocumentTypesUseCase listDocumentTypesUseCase(DocumentTypeRepository documentTypeRepository) {
        return new ListDocumentTypesUseCase(documentTypeRepository);
    }

    @Bean
    public UpdateDocumentTypeUseCase updateDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        return new UpdateDocumentTypeUseCase(documentTypeRepository);
    }

    @Bean
    public DeleteDocumentTypeUseCase deleteDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        return new DeleteDocumentTypeUseCase(documentTypeRepository);
    }
}
