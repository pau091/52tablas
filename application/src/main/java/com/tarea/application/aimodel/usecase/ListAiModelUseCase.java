package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

import java.util.List;

public class ListAiModelUseCase {

    private final AiModelRepository aiModelRepository;

    public ListAiModelUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public List<AiModelResponse> execute() {
        return aiModelRepository.findAll().stream()
                .map(AiModelResponse::fromDomain)
                .toList();
    }
}
