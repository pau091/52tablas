package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class GetProfessionalStudyByIdUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public GetProfessionalStudyByIdUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public ProfessionalStudyResponse execute(ProfessionalStudyId id) {
        var professionalStudy = professionalStudyRepository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id.value().toString()));
        return ProfessionalStudyResponse.fromDomain(professionalStudy);
    }
}
