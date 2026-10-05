package com.tarea.infrastructure.treatmentplan.config;

import com.tarea.application.treatmentplan.usecase.DeleteTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.GetTreatmentPlanByIdUseCase;
import com.tarea.application.treatmentplan.usecase.ListTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.RegisterTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.UpdateTreatmentPlanUseCase;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanPersistenceMapper;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanJpaRepository;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentPlanBeansConfig {

    @Bean
    public TreatmentPlanPersistenceMapper treatmentPlanPersistenceMapper() {
        return new TreatmentPlanPersistenceMapper();
    }

    @Bean
    public TreatmentPlanRepository treatmentPlanRepository(TreatmentPlanJpaRepository treatmentPlanJpaRepository, TreatmentPlanPersistenceMapper treatmentPlanPersistenceMapper) {
        return new TreatmentPlanRepositoryAdapter(treatmentPlanJpaRepository, treatmentPlanPersistenceMapper);
    }

    @Bean
    public RegisterTreatmentPlanUseCase registerTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        return new RegisterTreatmentPlanUseCase(treatmentPlanRepository);
    }

    @Bean
    public GetTreatmentPlanByIdUseCase getTreatmentPlanByIdUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        return new GetTreatmentPlanByIdUseCase(treatmentPlanRepository);
    }

    @Bean
    public ListTreatmentPlanUseCase listTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        return new ListTreatmentPlanUseCase(treatmentPlanRepository);
    }

    @Bean
    public UpdateTreatmentPlanUseCase updateTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        return new UpdateTreatmentPlanUseCase(treatmentPlanRepository);
    }

    @Bean
    public DeleteTreatmentPlanUseCase deleteTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        return new DeleteTreatmentPlanUseCase(treatmentPlanRepository);
    }
}
