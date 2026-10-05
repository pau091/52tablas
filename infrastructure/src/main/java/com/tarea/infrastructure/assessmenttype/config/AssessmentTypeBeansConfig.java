package com.tarea.infrastructure.assessmenttype.config;

import com.tarea.application.assessmenttype.usecase.DeleteAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.GetAssessmentTypeByIdUseCase;
import com.tarea.application.assessmenttype.usecase.ListAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.RegisterAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.UpdateAssessmentTypeUseCase;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.mappers.AssessmentTypePersistenceMapper;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories.AssessmentTypeJpaRepository;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories.AssessmentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssessmentTypeBeansConfig {

    @Bean
    public AssessmentTypePersistenceMapper assessmentTypePersistenceMapper() {
        return new AssessmentTypePersistenceMapper();
    }

    @Bean
    public AssessmentTypeRepository assessmentTypeRepository(AssessmentTypeJpaRepository assessmentTypeJpaRepository, AssessmentTypePersistenceMapper assessmentTypePersistenceMapper) {
        return new AssessmentTypeRepositoryAdapter(assessmentTypeJpaRepository, assessmentTypePersistenceMapper);
    }

    @Bean
    public RegisterAssessmentTypeUseCase registerAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        return new RegisterAssessmentTypeUseCase(assessmentTypeRepository);
    }

    @Bean
    public GetAssessmentTypeByIdUseCase getAssessmentTypeByIdUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        return new GetAssessmentTypeByIdUseCase(assessmentTypeRepository);
    }

    @Bean
    public ListAssessmentTypeUseCase listAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        return new ListAssessmentTypeUseCase(assessmentTypeRepository);
    }

    @Bean
    public UpdateAssessmentTypeUseCase updateAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        return new UpdateAssessmentTypeUseCase(assessmentTypeRepository);
    }

    @Bean
    public DeleteAssessmentTypeUseCase deleteAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        return new DeleteAssessmentTypeUseCase(assessmentTypeRepository);
    }
}
