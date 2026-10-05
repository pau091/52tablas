package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

import java.util.List;

public class ListTreatmentGoalUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public ListTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public List<TreatmentGoalResponse> execute() {
        return treatmentGoalRepository.findAll().stream()
                .map(TreatmentGoalResponse::fromDomain)
                .toList();
    }
}
