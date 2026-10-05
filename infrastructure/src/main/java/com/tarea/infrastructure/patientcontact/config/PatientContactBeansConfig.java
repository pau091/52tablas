package com.tarea.infrastructure.patientcontact.config;

import com.tarea.application.patientcontact.usecase.DeletePatientContactUseCase;
import com.tarea.application.patientcontact.usecase.GetPatientContactByIdUseCase;
import com.tarea.application.patientcontact.usecase.ListPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.RegisterPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.UpdatePatientContactUseCase;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactJpaRepository;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientContactBeansConfig {

    @Bean
    public PatientContactPersistenceMapper patientContactPersistenceMapper() {
        return new PatientContactPersistenceMapper();
    }

    @Bean
    public PatientContactRepository patientContactRepository(PatientContactJpaRepository patientContactJpaRepository, PatientContactPersistenceMapper patientContactPersistenceMapper) {
        return new PatientContactRepositoryAdapter(patientContactJpaRepository, patientContactPersistenceMapper);
    }

    @Bean
    public RegisterPatientContactUseCase registerPatientContactUseCase(PatientContactRepository patientContactRepository) {
        return new RegisterPatientContactUseCase(patientContactRepository);
    }

    @Bean
    public GetPatientContactByIdUseCase getPatientContactByIdUseCase(PatientContactRepository patientContactRepository) {
        return new GetPatientContactByIdUseCase(patientContactRepository);
    }

    @Bean
    public ListPatientContactUseCase listPatientContactUseCase(PatientContactRepository patientContactRepository) {
        return new ListPatientContactUseCase(patientContactRepository);
    }

    @Bean
    public UpdatePatientContactUseCase updatePatientContactUseCase(PatientContactRepository patientContactRepository) {
        return new UpdatePatientContactUseCase(patientContactRepository);
    }

    @Bean
    public DeletePatientContactUseCase deletePatientContactUseCase(PatientContactRepository patientContactRepository) {
        return new DeletePatientContactUseCase(patientContactRepository);
    }
}
