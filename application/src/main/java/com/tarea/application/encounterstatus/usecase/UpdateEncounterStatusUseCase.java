package com.tarea.application.encounterstatus.usecase;

import com.tarea.application.encounterstatus.command.UpdateEncounterStatusCommand;
import com.tarea.application.encounterstatus.dto.EncounterStatusResponse;
import com.tarea.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class UpdateEncounterStatusUseCase {

    private final EncounterStatusRepository encounterStatusRepository;

    public UpdateEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public EncounterStatusResponse execute(UpdateEncounterStatusCommand command) {
        var encounterStatus = encounterStatusRepository.findById(command.id())
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(command.id().value().toString()));
        encounterStatus.update(command.code(), command.name(), command.active());
        var updated = encounterStatusRepository.save(encounterStatus);
        return EncounterStatusResponse.fromDomain(updated);
    }
}
