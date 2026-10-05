package com.tarea.application.gender.usecase;

import com.tarea.application.gender.dto.GenderResponse;
import com.tarea.domain.gender.port.repository.GenderRepository;

import java.util.List;

public class ListGendersUseCase {

    private final GenderRepository genderRepository;

    public ListGendersUseCase(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<GenderResponse> execute() {
        return genderRepository.findAll().stream()
                .map(GenderResponse::fromDomain)
                .toList();
    }
}
