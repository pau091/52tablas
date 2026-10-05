package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

public class GetAiModelByIdUseCase {

    private final AiModelRepository aiModelRepository;

    public GetAiModelByIdUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public AiModelResponse execute(AiModelId id) {
        var aiModel = aiModelRepository.findById(id)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id.value().toString()));
        return AiModelResponse.fromDomain(aiModel);
    }
}
