package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

import java.util.List;

public class ListProfessionalStudyUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public ListProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public List<ProfessionalStudyResponse> execute() {
        return professionalStudyRepository.findAll().stream()
                .map(ProfessionalStudyResponse::fromDomain)
                .toList();
    }
}
