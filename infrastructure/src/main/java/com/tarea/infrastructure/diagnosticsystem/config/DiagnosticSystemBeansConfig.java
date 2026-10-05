package com.tarea.infrastructure.diagnosticsystem.config;

import com.tarea.application.diagnosticsystem.usecase.DeleteDiagnosticSystemUseCase;
import com.tarea.application.diagnosticsystem.usecase.GetDiagnosticSystemByIdUseCase;
import com.tarea.application.diagnosticsystem.usecase.ListDiagnosticSystemUseCase;
import com.tarea.application.diagnosticsystem.usecase.RegisterDiagnosticSystemUseCase;
import com.tarea.application.diagnosticsystem.usecase.UpdateDiagnosticSystemUseCase;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;
import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.mappers.DiagnosticSystemPersistenceMapper;
import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.repositories.DiagnosticSystemJpaRepository;
import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.repositories.DiagnosticSystemRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiagnosticSystemBeansConfig {

    @Bean
    public DiagnosticSystemPersistenceMapper diagnosticSystemPersistenceMapper() {
        return new DiagnosticSystemPersistenceMapper();
    }

    @Bean
    public DiagnosticSystemRepository diagnosticSystemRepository(DiagnosticSystemJpaRepository diagnosticSystemJpaRepository, DiagnosticSystemPersistenceMapper diagnosticSystemPersistenceMapper) {
        return new DiagnosticSystemRepositoryAdapter(diagnosticSystemJpaRepository, diagnosticSystemPersistenceMapper);
    }

    @Bean
    public RegisterDiagnosticSystemUseCase registerDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        return new RegisterDiagnosticSystemUseCase(diagnosticSystemRepository);
    }

    @Bean
    public GetDiagnosticSystemByIdUseCase getDiagnosticSystemByIdUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        return new GetDiagnosticSystemByIdUseCase(diagnosticSystemRepository);
    }

    @Bean
    public ListDiagnosticSystemUseCase listDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        return new ListDiagnosticSystemUseCase(diagnosticSystemRepository);
    }

    @Bean
    public UpdateDiagnosticSystemUseCase updateDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        return new UpdateDiagnosticSystemUseCase(diagnosticSystemRepository);
    }

    @Bean
    public DeleteDiagnosticSystemUseCase deleteDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        return new DeleteDiagnosticSystemUseCase(diagnosticSystemRepository);
    }
}
