package com.tarea.application.chatescalation.usecase;

import com.tarea.application.chatescalation.dto.ChatEscalationResponse;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;

import java.util.List;

public class ListChatEscalationUseCase {

    private final ChatEscalationRepository chatEscalationRepository;

    public ListChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        this.chatEscalationRepository = chatEscalationRepository;
    }

    public List<ChatEscalationResponse> execute() {
        return chatEscalationRepository.findAll().stream()
                .map(ChatEscalationResponse::fromDomain)
                .toList();
    }
}
