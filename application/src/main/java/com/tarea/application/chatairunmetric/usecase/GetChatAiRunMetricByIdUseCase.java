package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.tarea.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class GetChatAiRunMetricByIdUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public GetChatAiRunMetricByIdUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public ChatAiRunMetricResponse execute(ChatAiRunMetricId id) {
        var chatAiRunMetric = chatAiRunMetricRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id.value().toString()));
        return ChatAiRunMetricResponse.fromDomain(chatAiRunMetric);
    }
}
