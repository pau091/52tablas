package com.tarea.application.chatescalation.usecase;

import com.tarea.application.chatescalation.dto.ChatEscalationResponse;
import com.tarea.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;

public class GetChatEscalationByIdUseCase {

    private final ChatEscalationRepository chatEscalationRepository;

    public GetChatEscalationByIdUseCase(ChatEscalationRepository chatEscalationRepository) {
        this.chatEscalationRepository = chatEscalationRepository;
    }

    public ChatEscalationResponse execute(ChatEscalationId id) {
        var chatEscalation = chatEscalationRepository.findById(id)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id.value().toString()));
        return ChatEscalationResponse.fromDomain(chatEscalation);
    }
}
