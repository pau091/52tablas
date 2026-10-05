package com.tarea.application.consenttype.usecase;

import com.tarea.application.consenttype.dto.ConsentTypeResponse;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;

import java.util.List;

public class ListConsentTypeUseCase {

    private final ConsentTypeRepository consentTypeRepository;

    public ListConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        this.consentTypeRepository = consentTypeRepository;
    }

    public List<ConsentTypeResponse> execute() {
        return consentTypeRepository.findAll().stream()
                .map(ConsentTypeResponse::fromDomain)
                .toList();
    }
}
