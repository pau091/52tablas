package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.dto.StateRegionResponse;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

import java.util.List;

public class ListStateRegionsUseCase {

    private final StateRegionRepository stateRegionRepository;

    public ListStateRegionsUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public List<StateRegionResponse> execute() {
        return stateRegionRepository.findAll().stream()
                .map(StateRegionResponse::fromDomain)
                .toList();
    }
}
