package com.tarea.infrastructure.mentalstatusexam.config;

import com.tarea.application.mentalstatusexam.usecase.DeleteMentalStatusExamUseCase;
import com.tarea.application.mentalstatusexam.usecase.GetMentalStatusExamByIdUseCase;
import com.tarea.application.mentalstatusexam.usecase.ListMentalStatusExamUseCase;
import com.tarea.application.mentalstatusexam.usecase.RegisterMentalStatusExamUseCase;
import com.tarea.application.mentalstatusexam.usecase.UpdateMentalStatusExamUseCase;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;
import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.mappers.MentalStatusExamPersistenceMapper;
import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.repositories.MentalStatusExamJpaRepository;
import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.repositories.MentalStatusExamRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MentalStatusExamBeansConfig {

    @Bean
    public MentalStatusExamPersistenceMapper mentalStatusExamPersistenceMapper() {
        return new MentalStatusExamPersistenceMapper();
    }

    @Bean
    public MentalStatusExamRepository mentalStatusExamRepository(MentalStatusExamJpaRepository mentalStatusExamJpaRepository, MentalStatusExamPersistenceMapper mentalStatusExamPersistenceMapper) {
        return new MentalStatusExamRepositoryAdapter(mentalStatusExamJpaRepository, mentalStatusExamPersistenceMapper);
    }

    @Bean
    public RegisterMentalStatusExamUseCase registerMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        return new RegisterMentalStatusExamUseCase(mentalStatusExamRepository);
    }

    @Bean
    public GetMentalStatusExamByIdUseCase getMentalStatusExamByIdUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        return new GetMentalStatusExamByIdUseCase(mentalStatusExamRepository);
    }

    @Bean
    public ListMentalStatusExamUseCase listMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        return new ListMentalStatusExamUseCase(mentalStatusExamRepository);
    }

    @Bean
    public UpdateMentalStatusExamUseCase updateMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        return new UpdateMentalStatusExamUseCase(mentalStatusExamRepository);
    }

    @Bean
    public DeleteMentalStatusExamUseCase deleteMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        return new DeleteMentalStatusExamUseCase(mentalStatusExamRepository);
    }
}
