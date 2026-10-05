package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.dto.ChatParticipantResponse;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

import java.util.List;

public class ListChatParticipantUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public ListChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public List<ChatParticipantResponse> execute() {
        return chatParticipantRepository.findAll().stream()
                .map(ChatParticipantResponse::fromDomain)
                .toList();
    }
}
