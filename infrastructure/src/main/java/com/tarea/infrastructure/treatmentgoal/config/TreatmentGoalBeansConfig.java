package com.tarea.infrastructure.treatmentgoal.config;

import com.tarea.application.treatmentgoal.usecase.DeleteTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.GetTreatmentGoalByIdUseCase;
import com.tarea.application.treatmentgoal.usecase.ListTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.RegisterTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.UpdateTreatmentGoalUseCase;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalPersistenceMapper;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalJpaRepository;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentGoalBeansConfig {

    @Bean
    public TreatmentGoalPersistenceMapper treatmentGoalPersistenceMapper() {
        return new TreatmentGoalPersistenceMapper();
    }

    @Bean
    public TreatmentGoalRepository treatmentGoalRepository(TreatmentGoalJpaRepository treatmentGoalJpaRepository, TreatmentGoalPersistenceMapper treatmentGoalPersistenceMapper) {
        return new TreatmentGoalRepositoryAdapter(treatmentGoalJpaRepository, treatmentGoalPersistenceMapper);
    }

    @Bean
    public RegisterTreatmentGoalUseCase registerTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        return new RegisterTreatmentGoalUseCase(treatmentGoalRepository);
    }

    @Bean
    public GetTreatmentGoalByIdUseCase getTreatmentGoalByIdUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        return new GetTreatmentGoalByIdUseCase(treatmentGoalRepository);
    }

    @Bean
    public ListTreatmentGoalUseCase listTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        return new ListTreatmentGoalUseCase(treatmentGoalRepository);
    }

    @Bean
    public UpdateTreatmentGoalUseCase updateTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        return new UpdateTreatmentGoalUseCase(treatmentGoalRepository);
    }

    @Bean
    public DeleteTreatmentGoalUseCase deleteTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        return new DeleteTreatmentGoalUseCase(treatmentGoalRepository);
    }
}
