package com.tarea.infrastructure.professionaltype.config;

import com.tarea.application.professionaltype.usecase.DeleteProfessionalTypeUseCase;
import com.tarea.application.professionaltype.usecase.GetProfessionalTypeByIdUseCase;
import com.tarea.application.professionaltype.usecase.ListProfessionalTypesUseCase;
import com.tarea.application.professionaltype.usecase.RegisterProfessionalTypeUseCase;
import com.tarea.application.professionaltype.usecase.UpdateProfessionalTypeUseCase;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypePersistenceMapper;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeJpaRepository;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalTypeBeansConfig {

    @Bean
    public ProfessionalTypePersistenceMapper professionalTypePersistenceMapper() {
        return new ProfessionalTypePersistenceMapper();
    }

    @Bean
    public ProfessionalTypeRepository professionalTypeRepository(ProfessionalTypeJpaRepository professionalTypeJpaRepository, ProfessionalTypePersistenceMapper professionalTypePersistenceMapper) {
        return new ProfessionalTypeRepositoryAdapter(professionalTypeJpaRepository, professionalTypePersistenceMapper);
    }

    @Bean
    public RegisterProfessionalTypeUseCase registerProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        return new RegisterProfessionalTypeUseCase(professionalTypeRepository);
    }

    @Bean
    public GetProfessionalTypeByIdUseCase getProfessionalTypeByIdUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        return new GetProfessionalTypeByIdUseCase(professionalTypeRepository);
    }

    @Bean
    public ListProfessionalTypesUseCase listProfessionalTypesUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        return new ListProfessionalTypesUseCase(professionalTypeRepository);
    }

    @Bean
    public UpdateProfessionalTypeUseCase updateProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        return new UpdateProfessionalTypeUseCase(professionalTypeRepository);
    }

    @Bean
    public DeleteProfessionalTypeUseCase deleteProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        return new DeleteProfessionalTypeUseCase(professionalTypeRepository);
    }
}
