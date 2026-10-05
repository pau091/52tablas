package com.tarea.infrastructure.treatmentstatus.config;

import com.tarea.application.treatmentstatus.usecase.DeleteTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.GetTreatmentStatusByIdUseCase;
import com.tarea.application.treatmentstatus.usecase.ListTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.RegisterTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.UpdateTreatmentStatusUseCase;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.mappers.TreatmentStatusPersistenceMapper;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusJpaRepository;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentStatusBeansConfig {

    @Bean
    public TreatmentStatusPersistenceMapper treatmentStatusPersistenceMapper() {
        return new TreatmentStatusPersistenceMapper();
    }

    @Bean
    public TreatmentStatusRepository treatmentStatusRepository(TreatmentStatusJpaRepository treatmentStatusJpaRepository, TreatmentStatusPersistenceMapper treatmentStatusPersistenceMapper) {
        return new TreatmentStatusRepositoryAdapter(treatmentStatusJpaRepository, treatmentStatusPersistenceMapper);
    }

    @Bean
    public RegisterTreatmentStatusUseCase registerTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        return new RegisterTreatmentStatusUseCase(treatmentStatusRepository);
    }

    @Bean
    public GetTreatmentStatusByIdUseCase getTreatmentStatusByIdUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        return new GetTreatmentStatusByIdUseCase(treatmentStatusRepository);
    }

    @Bean
    public ListTreatmentStatusUseCase listTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        return new ListTreatmentStatusUseCase(treatmentStatusRepository);
    }

    @Bean
    public UpdateTreatmentStatusUseCase updateTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        return new UpdateTreatmentStatusUseCase(treatmentStatusRepository);
    }

    @Bean
    public DeleteTreatmentStatusUseCase deleteTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        return new DeleteTreatmentStatusUseCase(treatmentStatusRepository);
    }
}
