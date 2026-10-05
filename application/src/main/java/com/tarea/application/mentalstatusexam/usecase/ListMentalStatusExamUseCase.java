package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

import java.util.List;

public class ListMentalStatusExamUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public ListMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public List<MentalStatusExamResponse> execute() {
        return mentalStatusExamRepository.findAll().stream()
                .map(MentalStatusExamResponse::fromDomain)
                .toList();
    }
}
