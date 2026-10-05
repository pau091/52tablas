package com.tarea.infrastructure.medicationroute.config;

import com.tarea.application.medicationroute.usecase.DeleteMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.GetMedicationRouteByIdUseCase;
import com.tarea.application.medicationroute.usecase.ListMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.RegisterMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.UpdateMedicationRouteUseCase;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.mappers.MedicationRoutePersistenceMapper;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories.MedicationRouteJpaRepository;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories.MedicationRouteRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicationRouteBeansConfig {

    @Bean
    public MedicationRoutePersistenceMapper medicationRoutePersistenceMapper() {
        return new MedicationRoutePersistenceMapper();
    }

    @Bean
    public MedicationRouteRepository medicationRouteRepository(MedicationRouteJpaRepository medicationRouteJpaRepository, MedicationRoutePersistenceMapper medicationRoutePersistenceMapper) {
        return new MedicationRouteRepositoryAdapter(medicationRouteJpaRepository, medicationRoutePersistenceMapper);
    }

    @Bean
    public RegisterMedicationRouteUseCase registerMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        return new RegisterMedicationRouteUseCase(medicationRouteRepository);
    }

    @Bean
    public GetMedicationRouteByIdUseCase getMedicationRouteByIdUseCase(MedicationRouteRepository medicationRouteRepository) {
        return new GetMedicationRouteByIdUseCase(medicationRouteRepository);
    }

    @Bean
    public ListMedicationRouteUseCase listMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        return new ListMedicationRouteUseCase(medicationRouteRepository);
    }

    @Bean
    public UpdateMedicationRouteUseCase updateMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        return new UpdateMedicationRouteUseCase(medicationRouteRepository);
    }

    @Bean
    public DeleteMedicationRouteUseCase deleteMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        return new DeleteMedicationRouteUseCase(medicationRouteRepository);
    }
}
