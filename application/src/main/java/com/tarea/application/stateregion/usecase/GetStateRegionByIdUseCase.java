package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.dto.StateRegionResponse;
import com.tarea.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

public class GetStateRegionByIdUseCase {

    private final StateRegionRepository stateRegionRepository;

    public GetStateRegionByIdUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public StateRegionResponse execute(StateRegionId id) {
        var stateRegion = stateRegionRepository.findById(id)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id.value().toString()));
        return StateRegionResponse.fromDomain(stateRegion);
    }
}
