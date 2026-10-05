package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

import java.util.List;

public class ListChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public ListChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public List<ChatAiRunMetricResponse> execute() {
        return chatAiRunMetricRepository.findAll().stream()
                .map(ChatAiRunMetricResponse::fromDomain)
                .toList();
    }
}
