package com.tarea.infrastructure.clinicalrecordstatus.config;

import com.tarea.application.clinicalrecordstatus.usecase.DeleteClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.GetClinicalRecordStatusByIdUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.ListClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.RegisterClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.UpdateClinicalRecordStatusUseCase;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.mappers.ClinicalRecordStatusPersistenceMapper;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories.ClinicalRecordStatusJpaRepository;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories.ClinicalRecordStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalRecordStatusBeansConfig {

    @Bean
    public ClinicalRecordStatusPersistenceMapper clinicalRecordStatusPersistenceMapper() {
        return new ClinicalRecordStatusPersistenceMapper();
    }

    @Bean
    public ClinicalRecordStatusRepository clinicalRecordStatusRepository(ClinicalRecordStatusJpaRepository clinicalRecordStatusJpaRepository, ClinicalRecordStatusPersistenceMapper clinicalRecordStatusPersistenceMapper) {
        return new ClinicalRecordStatusRepositoryAdapter(clinicalRecordStatusJpaRepository, clinicalRecordStatusPersistenceMapper);
    }

    @Bean
    public RegisterClinicalRecordStatusUseCase registerClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new RegisterClinicalRecordStatusUseCase(clinicalRecordStatusRepository);
    }

    @Bean
    public GetClinicalRecordStatusByIdUseCase getClinicalRecordStatusByIdUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new GetClinicalRecordStatusByIdUseCase(clinicalRecordStatusRepository);
    }

    @Bean
    public ListClinicalRecordStatusUseCase listClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new ListClinicalRecordStatusUseCase(clinicalRecordStatusRepository);
    }

    @Bean
    public UpdateClinicalRecordStatusUseCase updateClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new UpdateClinicalRecordStatusUseCase(clinicalRecordStatusRepository);
    }

    @Bean
    public DeleteClinicalRecordStatusUseCase deleteClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new DeleteClinicalRecordStatusUseCase(clinicalRecordStatusRepository);
    }
}
