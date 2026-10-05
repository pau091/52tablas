package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.tarea.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class GetMentalStatusExamByIdUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public GetMentalStatusExamByIdUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public MentalStatusExamResponse execute(MentalStatusExamId id) {
        var mentalStatusExam = mentalStatusExamRepository.findById(id)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id.value().toString()));
        return MentalStatusExamResponse.fromDomain(mentalStatusExam);
    }
}
