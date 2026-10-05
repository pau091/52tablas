package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.dto.ProfessionalTypeResponse;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

import java.util.List;

public class ListProfessionalTypesUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public ListProfessionalTypesUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public List<ProfessionalTypeResponse> execute() {
        return professionalTypeRepository.findAll().stream()
                .map(ProfessionalTypeResponse::fromDomain)
                .toList();
    }
}
