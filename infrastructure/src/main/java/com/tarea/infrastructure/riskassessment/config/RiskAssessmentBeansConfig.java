package com.tarea.infrastructure.riskassessment.config;

import com.tarea.application.riskassessment.usecase.DeleteRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.GetRiskAssessmentByIdUseCase;
import com.tarea.application.riskassessment.usecase.ListRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.RegisterRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.UpdateRiskAssessmentUseCase;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentJpaRepository;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiskAssessmentBeansConfig {

    @Bean
    public RiskAssessmentPersistenceMapper riskAssessmentPersistenceMapper() {
        return new RiskAssessmentPersistenceMapper();
    }

    @Bean
    public RiskAssessmentRepository riskAssessmentRepository(RiskAssessmentJpaRepository riskAssessmentJpaRepository, RiskAssessmentPersistenceMapper riskAssessmentPersistenceMapper) {
        return new RiskAssessmentRepositoryAdapter(riskAssessmentJpaRepository, riskAssessmentPersistenceMapper);
    }

    @Bean
    public RegisterRiskAssessmentUseCase registerRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        return new RegisterRiskAssessmentUseCase(riskAssessmentRepository);
    }

    @Bean
    public GetRiskAssessmentByIdUseCase getRiskAssessmentByIdUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        return new GetRiskAssessmentByIdUseCase(riskAssessmentRepository);
    }

    @Bean
    public ListRiskAssessmentUseCase listRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        return new ListRiskAssessmentUseCase(riskAssessmentRepository);
    }

    @Bean
    public UpdateRiskAssessmentUseCase updateRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        return new UpdateRiskAssessmentUseCase(riskAssessmentRepository);
    }

    @Bean
    public DeleteRiskAssessmentUseCase deleteRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        return new DeleteRiskAssessmentUseCase(riskAssessmentRepository);
    }
}
