package com.tarea.application.chatairunerror.usecase;

import com.tarea.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

import java.util.List;

public class ListChatAiRunErrorUseCase {

    private final ChatAiRunErrorRepository chatAiRunErrorRepository;

    public ListChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        this.chatAiRunErrorRepository = chatAiRunErrorRepository;
    }

    public List<ChatAiRunErrorResponse> execute() {
        return chatAiRunErrorRepository.findAll().stream()
                .map(ChatAiRunErrorResponse::fromDomain)
                .toList();
    }
}
