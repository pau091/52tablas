package com.tarea.infrastructure.study.config;

import com.tarea.application.study.usecase.DeleteStudyUseCase;
import com.tarea.application.study.usecase.GetStudyByIdUseCase;
import com.tarea.application.study.usecase.ListStudiesUseCase;
import com.tarea.application.study.usecase.RegisterStudyUseCase;
import com.tarea.application.study.usecase.UpdateStudyUseCase;
import com.tarea.domain.study.port.repository.StudyRepository;
import com.tarea.infrastructure.study.adapters.out.persistence.mappers.StudyPersistenceMapper;
import com.tarea.infrastructure.study.adapters.out.persistence.repositories.StudyJpaRepository;
import com.tarea.infrastructure.study.adapters.out.persistence.repositories.StudyRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudyBeansConfig {

    @Bean
    public StudyPersistenceMapper studyPersistenceMapper() {
        return new StudyPersistenceMapper();
    }

    @Bean
    public StudyRepository studyRepository(StudyJpaRepository studyJpaRepository, StudyPersistenceMapper studyPersistenceMapper) {
        return new StudyRepositoryAdapter(studyJpaRepository, studyPersistenceMapper);
    }

    @Bean
    public RegisterStudyUseCase registerStudyUseCase(StudyRepository studyRepository) {
        return new RegisterStudyUseCase(studyRepository);
    }

    @Bean
    public GetStudyByIdUseCase getStudyByIdUseCase(StudyRepository studyRepository) {
        return new GetStudyByIdUseCase(studyRepository);
    }

    @Bean
    public ListStudiesUseCase listStudiesUseCase(StudyRepository studyRepository) {
        return new ListStudiesUseCase(studyRepository);
    }

    @Bean
    public UpdateStudyUseCase updateStudyUseCase(StudyRepository studyRepository) {
        return new UpdateStudyUseCase(studyRepository);
    }

    @Bean
    public DeleteStudyUseCase deleteStudyUseCase(StudyRepository studyRepository) {
        return new DeleteStudyUseCase(studyRepository);
    }
}
