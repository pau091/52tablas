package com.tarea.infrastructure.clinicalrecord.config;

import com.tarea.application.clinicalrecord.usecase.DeleteClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.GetClinicalRecordByIdUseCase;
import com.tarea.application.clinicalrecord.usecase.ListClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.RegisterClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.UpdateClinicalRecordUseCase;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordJpaRepository;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalRecordBeansConfig {

    @Bean
    public ClinicalRecordPersistenceMapper clinicalRecordPersistenceMapper() {
        return new ClinicalRecordPersistenceMapper();
    }

    @Bean
    public ClinicalRecordRepository clinicalRecordRepository(ClinicalRecordJpaRepository clinicalRecordJpaRepository, ClinicalRecordPersistenceMapper clinicalRecordPersistenceMapper) {
        return new ClinicalRecordRepositoryAdapter(clinicalRecordJpaRepository, clinicalRecordPersistenceMapper);
    }

    @Bean
    public RegisterClinicalRecordUseCase registerClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        return new RegisterClinicalRecordUseCase(clinicalRecordRepository);
    }

    @Bean
    public GetClinicalRecordByIdUseCase getClinicalRecordByIdUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        return new GetClinicalRecordByIdUseCase(clinicalRecordRepository);
    }

    @Bean
    public ListClinicalRecordUseCase listClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        return new ListClinicalRecordUseCase(clinicalRecordRepository);
    }

    @Bean
    public UpdateClinicalRecordUseCase updateClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        return new UpdateClinicalRecordUseCase(clinicalRecordRepository);
    }

    @Bean
    public DeleteClinicalRecordUseCase deleteClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        return new DeleteClinicalRecordUseCase(clinicalRecordRepository);
    }
}
