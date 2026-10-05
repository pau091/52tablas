package com.tarea.infrastructure.risklevel.config;

import com.tarea.application.risklevel.usecase.DeleteRiskLevelUseCase;
import com.tarea.application.risklevel.usecase.GetRiskLevelByIdUseCase;
import com.tarea.application.risklevel.usecase.ListRiskLevelUseCase;
import com.tarea.application.risklevel.usecase.RegisterRiskLevelUseCase;
import com.tarea.application.risklevel.usecase.UpdateRiskLevelUseCase;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;
import com.tarea.infrastructure.risklevel.adapters.out.persistence.mappers.RiskLevelPersistenceMapper;
import com.tarea.infrastructure.risklevel.adapters.out.persistence.repositories.RiskLevelJpaRepository;
import com.tarea.infrastructure.risklevel.adapters.out.persistence.repositories.RiskLevelRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiskLevelBeansConfig {

    @Bean
    public RiskLevelPersistenceMapper riskLevelPersistenceMapper() {
        return new RiskLevelPersistenceMapper();
    }

    @Bean
    public RiskLevelRepository riskLevelRepository(RiskLevelJpaRepository riskLevelJpaRepository, RiskLevelPersistenceMapper riskLevelPersistenceMapper) {
        return new RiskLevelRepositoryAdapter(riskLevelJpaRepository, riskLevelPersistenceMapper);
    }

    @Bean
    public RegisterRiskLevelUseCase registerRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        return new RegisterRiskLevelUseCase(riskLevelRepository);
    }

    @Bean
    public GetRiskLevelByIdUseCase getRiskLevelByIdUseCase(RiskLevelRepository riskLevelRepository) {
        return new GetRiskLevelByIdUseCase(riskLevelRepository);
    }

    @Bean
    public ListRiskLevelUseCase listRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        return new ListRiskLevelUseCase(riskLevelRepository);
    }

    @Bean
    public UpdateRiskLevelUseCase updateRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        return new UpdateRiskLevelUseCase(riskLevelRepository);
    }

    @Bean
    public DeleteRiskLevelUseCase deleteRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        return new DeleteRiskLevelUseCase(riskLevelRepository);
    }
}
