package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.command.RegisterMentalStatusExamCommand;
import com.tarea.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.tarea.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class RegisterMentalStatusExamUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public RegisterMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public MentalStatusExamResponse execute(RegisterMentalStatusExamCommand command) {
        MentalStatusExam mentalStatusExam = MentalStatusExam.register(
                command.encounterId(),
                command.appearance(),
                command.behavior(),
                command.attitude(),
                command.consciousness(),
                command.orientation(),
                command.attention(),
                command.memory(),
                command.speech(),
                command.mood(),
                command.affect(),
                command.thoughtProcess(),
                command.thoughtContent(),
                command.perception(),
                command.judgment(),
                command.insight(),
                command.psychomotorActivity(),
                command.observations(),
                command.createdBy());
        MentalStatusExam saved = mentalStatusExamRepository.save(mentalStatusExam);
        return MentalStatusExamResponse.fromDomain(saved);
    }
}
