package com.tarea.infrastructure.professionalstudy.config;

import com.tarea.application.professionalstudy.usecase.DeleteProfessionalStudyUseCase;
import com.tarea.application.professionalstudy.usecase.GetProfessionalStudyByIdUseCase;
import com.tarea.application.professionalstudy.usecase.ListProfessionalStudyUseCase;
import com.tarea.application.professionalstudy.usecase.RegisterProfessionalStudyUseCase;
import com.tarea.application.professionalstudy.usecase.UpdateProfessionalStudyUseCase;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.tarea.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyPersistenceMapper;
import com.tarea.infrastructure.professionalstudy.adapters.out.persistence.repositories.ProfessionalStudyJpaRepository;
import com.tarea.infrastructure.professionalstudy.adapters.out.persistence.repositories.ProfessionalStudyRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalStudyBeansConfig {

    @Bean
    public ProfessionalStudyPersistenceMapper professionalStudyPersistenceMapper() {
        return new ProfessionalStudyPersistenceMapper();
    }

    @Bean
    public ProfessionalStudyRepository professionalStudyRepository(ProfessionalStudyJpaRepository professionalStudyJpaRepository, ProfessionalStudyPersistenceMapper professionalStudyPersistenceMapper) {
        return new ProfessionalStudyRepositoryAdapter(professionalStudyJpaRepository, professionalStudyPersistenceMapper);
    }

    @Bean
    public RegisterProfessionalStudyUseCase registerProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        return new RegisterProfessionalStudyUseCase(professionalStudyRepository);
    }

    @Bean
    public GetProfessionalStudyByIdUseCase getProfessionalStudyByIdUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        return new GetProfessionalStudyByIdUseCase(professionalStudyRepository);
    }

    @Bean
    public ListProfessionalStudyUseCase listProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        return new ListProfessionalStudyUseCase(professionalStudyRepository);
    }

    @Bean
    public UpdateProfessionalStudyUseCase updateProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        return new UpdateProfessionalStudyUseCase(professionalStudyRepository);
    }

    @Bean
    public DeleteProfessionalStudyUseCase deleteProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        return new DeleteProfessionalStudyUseCase(professionalStudyRepository);
    }
}
