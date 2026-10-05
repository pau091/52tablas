package com.tarea.infrastructure.professional.config;

import com.tarea.application.professional.usecase.DeleteProfessionalUseCase;
import com.tarea.application.professional.usecase.GetProfessionalByIdUseCase;
import com.tarea.application.professional.usecase.ListProfessionalUseCase;
import com.tarea.application.professional.usecase.RegisterProfessionalUseCase;
import com.tarea.application.professional.usecase.UpdateProfessionalUseCase;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;
import com.tarea.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;
import com.tarea.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalJpaRepository;
import com.tarea.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalBeansConfig {

    @Bean
    public ProfessionalPersistenceMapper professionalPersistenceMapper() {
        return new ProfessionalPersistenceMapper();
    }

    @Bean
    public ProfessionalRepository professionalRepository(ProfessionalJpaRepository professionalJpaRepository, ProfessionalPersistenceMapper professionalPersistenceMapper) {
        return new ProfessionalRepositoryAdapter(professionalJpaRepository, professionalPersistenceMapper);
    }

    @Bean
    public RegisterProfessionalUseCase registerProfessionalUseCase(ProfessionalRepository professionalRepository) {
        return new RegisterProfessionalUseCase(professionalRepository);
    }

    @Bean
    public GetProfessionalByIdUseCase getProfessionalByIdUseCase(ProfessionalRepository professionalRepository) {
        return new GetProfessionalByIdUseCase(professionalRepository);
    }

    @Bean
    public ListProfessionalUseCase listProfessionalUseCase(ProfessionalRepository professionalRepository) {
        return new ListProfessionalUseCase(professionalRepository);
    }

    @Bean
    public UpdateProfessionalUseCase updateProfessionalUseCase(ProfessionalRepository professionalRepository) {
        return new UpdateProfessionalUseCase(professionalRepository);
    }

    @Bean
    public DeleteProfessionalUseCase deleteProfessionalUseCase(ProfessionalRepository professionalRepository) {
        return new DeleteProfessionalUseCase(professionalRepository);
    }
}
