package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.command.RegisterProfessionalStudyCommand;
import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class RegisterProfessionalStudyUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public RegisterProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public ProfessionalStudyResponse execute(RegisterProfessionalStudyCommand command) {
        ProfessionalStudy professionalStudy = ProfessionalStudy.register(
                command.studyId(),
                command.professionalId(),
                command.title(),
                command.university(),
                command.isValid(),
                command.resolutionNumber(),
                command.countryId());
        ProfessionalStudy saved = professionalStudyRepository.save(professionalStudy);
        return ProfessionalStudyResponse.fromDomain(saved);
    }
}
