package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.command.RegisterTreatmentGoalCommand;
import com.tarea.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.tarea.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class RegisterTreatmentGoalUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public RegisterTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public TreatmentGoalResponse execute(RegisterTreatmentGoalCommand command) {
        TreatmentGoal treatmentGoal = TreatmentGoal.register(
                command.treatmentPlanId(),
                command.description(),
                command.targetDate(),
                command.completedAt(),
                command.notes(),
                command.treatmentGoalId());
        TreatmentGoal saved = treatmentGoalRepository.save(treatmentGoal);
        return TreatmentGoalResponse.fromDomain(saved);
    }
}
