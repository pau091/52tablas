package com.tarea.infrastructure.patient.config;

import com.tarea.application.patient.usecase.DeletePatientUseCase;
import com.tarea.application.patient.usecase.GetPatientByIdUseCase;
import com.tarea.application.patient.usecase.ListPatientsUseCase;
import com.tarea.application.patient.usecase.RegisterPatientUseCase;
import com.tarea.application.patient.usecase.UpdatePatientUseCase;
import com.tarea.domain.patient.port.repository.PatientRepository;
import com.tarea.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;
import com.tarea.infrastructure.patient.adapters.out.persistence.repositories.PatientJpaRepository;
import com.tarea.infrastructure.patient.adapters.out.persistence.repositories.PatientRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientBeansConfig {

    @Bean
    public PatientPersistenceMapper patientPersistenceMapper() {
        return new PatientPersistenceMapper();
    }

    @Bean
    public PatientRepository patientRepository(PatientJpaRepository patientJpaRepository, PatientPersistenceMapper patientPersistenceMapper) {
        return new PatientRepositoryAdapter(patientJpaRepository, patientPersistenceMapper);
    }

    @Bean
    public RegisterPatientUseCase registerPatientUseCase(PatientRepository patientRepository) {
        return new RegisterPatientUseCase(patientRepository);
    }

    @Bean
    public GetPatientByIdUseCase getPatientByIdUseCase(PatientRepository patientRepository) {
        return new GetPatientByIdUseCase(patientRepository);
    }

    @Bean
    public ListPatientsUseCase listPatientsUseCase(PatientRepository patientRepository) {
        return new ListPatientsUseCase(patientRepository);
    }

    @Bean
    public UpdatePatientUseCase updatePatientUseCase(PatientRepository patientRepository) {
        return new UpdatePatientUseCase(patientRepository);
    }

    @Bean
    public DeletePatientUseCase deletePatientUseCase(PatientRepository patientRepository) {
        return new DeletePatientUseCase(patientRepository);
    }
}
