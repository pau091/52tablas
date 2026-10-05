package com.tarea.application.encounter.usecase;

import com.tarea.application.encounter.command.RegisterEncounterCommand;
import com.tarea.application.encounter.dto.EncounterResponse;
import com.tarea.domain.encounter.model.aggregate.Encounter;
import com.tarea.domain.encounter.port.repository.EncounterRepository;

public class RegisterEncounterUseCase {

    private final EncounterRepository encounterRepository;

    public RegisterEncounterUseCase(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public EncounterResponse execute(RegisterEncounterCommand command) {
        Encounter encounter = Encounter.register(
                command.clinicalRecordId(),
                command.professionalId(),
                command.encounterTypeId(),
                command.startedAt(),
                command.endedAt(),
                command.reasonForVisit(),
                command.currentCondition(),
                command.modalityId(),
                command.statusId(),
                command.createdBy(),
                command.updatedBy());
        Encounter saved = encounterRepository.save(encounter);
        return EncounterResponse.fromDomain(saved);
    }
}
