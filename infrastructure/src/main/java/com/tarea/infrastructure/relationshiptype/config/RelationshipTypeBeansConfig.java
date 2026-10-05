package com.tarea.infrastructure.relationshiptype.config;

import com.tarea.application.relationshiptype.usecase.DeleteRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.GetRelationshipTypeByIdUseCase;
import com.tarea.application.relationshiptype.usecase.ListRelationshipTypesUseCase;
import com.tarea.application.relationshiptype.usecase.RegisterRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.UpdateRelationshipTypeUseCase;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypePersistenceMapper;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeJpaRepository;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RelationshipTypeBeansConfig {

    @Bean
    public RelationshipTypePersistenceMapper relationshipTypePersistenceMapper() {
        return new RelationshipTypePersistenceMapper();
    }

    @Bean
    public RelationshipTypeRepository relationshipTypeRepository(RelationshipTypeJpaRepository relationshipTypeJpaRepository, RelationshipTypePersistenceMapper relationshipTypePersistenceMapper) {
        return new RelationshipTypeRepositoryAdapter(relationshipTypeJpaRepository, relationshipTypePersistenceMapper);
    }

    @Bean
    public RegisterRelationshipTypeUseCase registerRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        return new RegisterRelationshipTypeUseCase(relationshipTypeRepository);
    }

    @Bean
    public GetRelationshipTypeByIdUseCase getRelationshipTypeByIdUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        return new GetRelationshipTypeByIdUseCase(relationshipTypeRepository);
    }

    @Bean
    public ListRelationshipTypesUseCase listRelationshipTypesUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        return new ListRelationshipTypesUseCase(relationshipTypeRepository);
    }

    @Bean
    public UpdateRelationshipTypeUseCase updateRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        return new UpdateRelationshipTypeUseCase(relationshipTypeRepository);
    }

    @Bean
    public DeleteRelationshipTypeUseCase deleteRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        return new DeleteRelationshipTypeUseCase(relationshipTypeRepository);
    }
}
