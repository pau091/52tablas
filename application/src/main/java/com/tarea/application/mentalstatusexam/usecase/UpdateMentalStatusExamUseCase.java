package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.command.UpdateMentalStatusExamCommand;
import com.tarea.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.tarea.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class UpdateMentalStatusExamUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public UpdateMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public MentalStatusExamResponse execute(UpdateMentalStatusExamCommand command) {
        var mentalStatusExam = mentalStatusExamRepository.findById(command.id())
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(command.id().value().toString()));
        mentalStatusExam.update(
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
                command.observations());
        var updated = mentalStatusExamRepository.save(mentalStatusExam);
        return MentalStatusExamResponse.fromDomain(updated);
    }
}
