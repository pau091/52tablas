package com.tarea.infrastructure.treatmentgoalstatus.config;

import com.tarea.application.treatmentgoalstatus.usecase.DeleteTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.GetTreatmentGoalStatusByIdUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.ListTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.RegisterTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.UpdateTreatmentGoalStatusUseCase;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.mappers.TreatmentGoalStatusPersistenceMapper;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories.TreatmentGoalStatusJpaRepository;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories.TreatmentGoalStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentGoalStatusBeansConfig {

    @Bean
    public TreatmentGoalStatusPersistenceMapper treatmentGoalStatusPersistenceMapper() {
        return new TreatmentGoalStatusPersistenceMapper();
    }

    @Bean
    public TreatmentGoalStatusRepository treatmentGoalStatusRepository(TreatmentGoalStatusJpaRepository treatmentGoalStatusJpaRepository, TreatmentGoalStatusPersistenceMapper treatmentGoalStatusPersistenceMapper) {
        return new TreatmentGoalStatusRepositoryAdapter(treatmentGoalStatusJpaRepository, treatmentGoalStatusPersistenceMapper);
    }

    @Bean
    public RegisterTreatmentGoalStatusUseCase registerTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new RegisterTreatmentGoalStatusUseCase(treatmentGoalStatusRepository);
    }

    @Bean
    public GetTreatmentGoalStatusByIdUseCase getTreatmentGoalStatusByIdUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new GetTreatmentGoalStatusByIdUseCase(treatmentGoalStatusRepository);
    }

    @Bean
    public ListTreatmentGoalStatusUseCase listTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new ListTreatmentGoalStatusUseCase(treatmentGoalStatusRepository);
    }

    @Bean
    public UpdateTreatmentGoalStatusUseCase updateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new UpdateTreatmentGoalStatusUseCase(treatmentGoalStatusRepository);
    }

    @Bean
    public DeleteTreatmentGoalStatusUseCase deleteTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new DeleteTreatmentGoalStatusUseCase(treatmentGoalStatusRepository);
    }
}
