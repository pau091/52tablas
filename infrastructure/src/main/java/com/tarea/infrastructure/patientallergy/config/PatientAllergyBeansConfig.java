package com.tarea.infrastructure.patientallergy.config;

import com.tarea.application.patientallergy.usecase.DeletePatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.GetPatientAllergyByIdUseCase;
import com.tarea.application.patientallergy.usecase.ListPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.RegisterPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.UpdatePatientAllergyUseCase;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyJpaRepository;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientAllergyBeansConfig {

    @Bean
    public PatientAllergyPersistenceMapper patientAllergyPersistenceMapper() {
        return new PatientAllergyPersistenceMapper();
    }

    @Bean
    public PatientAllergyRepository patientAllergyRepository(PatientAllergyJpaRepository patientAllergyJpaRepository, PatientAllergyPersistenceMapper patientAllergyPersistenceMapper) {
        return new PatientAllergyRepositoryAdapter(patientAllergyJpaRepository, patientAllergyPersistenceMapper);
    }

    @Bean
    public RegisterPatientAllergyUseCase registerPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        return new RegisterPatientAllergyUseCase(patientAllergyRepository);
    }

    @Bean
    public GetPatientAllergyByIdUseCase getPatientAllergyByIdUseCase(PatientAllergyRepository patientAllergyRepository) {
        return new GetPatientAllergyByIdUseCase(patientAllergyRepository);
    }

    @Bean
    public ListPatientAllergyUseCase listPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        return new ListPatientAllergyUseCase(patientAllergyRepository);
    }

    @Bean
    public UpdatePatientAllergyUseCase updatePatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        return new UpdatePatientAllergyUseCase(patientAllergyRepository);
    }

    @Bean
    public DeletePatientAllergyUseCase deletePatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        return new DeletePatientAllergyUseCase(patientAllergyRepository);
    }
}
