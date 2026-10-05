package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.dto.ProviderModelAiResponse;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

import java.util.List;

public class ListProviderModelAiUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public ListProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public List<ProviderModelAiResponse> execute() {
        return providerModelAiRepository.findAll().stream()
                .map(ProviderModelAiResponse::fromDomain)
                .toList();
    }
}
