package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

import java.util.List;

public class ListChatAiRunUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public ListChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public List<ChatAiRunResponse> execute() {
        return chatAiRunRepository.findAll().stream()
                .map(ChatAiRunResponse::fromDomain)
                .toList();
    }
}
