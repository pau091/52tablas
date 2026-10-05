package com.tarea.infrastructure.clinicalnote.config;

import com.tarea.application.clinicalnote.usecase.DeleteClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.GetClinicalNoteByIdUseCase;
import com.tarea.application.clinicalnote.usecase.ListClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.RegisterClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.UpdateClinicalNoteUseCase;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteJpaRepository;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalNoteBeansConfig {

    @Bean
    public ClinicalNotePersistenceMapper clinicalNotePersistenceMapper() {
        return new ClinicalNotePersistenceMapper();
    }

    @Bean
    public ClinicalNoteRepository clinicalNoteRepository(ClinicalNoteJpaRepository clinicalNoteJpaRepository, ClinicalNotePersistenceMapper clinicalNotePersistenceMapper) {
        return new ClinicalNoteRepositoryAdapter(clinicalNoteJpaRepository, clinicalNotePersistenceMapper);
    }

    @Bean
    public RegisterClinicalNoteUseCase registerClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        return new RegisterClinicalNoteUseCase(clinicalNoteRepository);
    }

    @Bean
    public GetClinicalNoteByIdUseCase getClinicalNoteByIdUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        return new GetClinicalNoteByIdUseCase(clinicalNoteRepository);
    }

    @Bean
    public ListClinicalNoteUseCase listClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        return new ListClinicalNoteUseCase(clinicalNoteRepository);
    }

    @Bean
    public UpdateClinicalNoteUseCase updateClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        return new UpdateClinicalNoteUseCase(clinicalNoteRepository);
    }

    @Bean
    public DeleteClinicalNoteUseCase deleteClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        return new DeleteClinicalNoteUseCase(clinicalNoteRepository);
    }
}
