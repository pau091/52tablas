package com.tarea.application.professional.usecase;

import com.tarea.application.professional.command.RegisterProfessionalCommand;
import com.tarea.application.professional.dto.ProfessionalResponse;
import com.tarea.domain.professional.model.aggregate.Professional;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

public class RegisterProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    public RegisterProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public ProfessionalResponse execute(RegisterProfessionalCommand command) {
        Professional professional = Professional.register(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.lastName(),
                command.professionalType(),
                command.licenseNumber(),
                command.active(),
                command.cityId());
        Professional saved = professionalRepository.save(professional);
        return ProfessionalResponse.fromDomain(saved);
    }
}
