package com.tarea.application.chatconversation.usecase;

import com.tarea.application.chatconversation.dto.ChatConversationResponse;
import com.tarea.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;

public class GetChatConversationByIdUseCase {

    private final ChatConversationRepository chatConversationRepository;

    public GetChatConversationByIdUseCase(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    public ChatConversationResponse execute(ChatConversationId id) {
        var chatConversation = chatConversationRepository.findById(id)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id.value().toString()));
        return ChatConversationResponse.fromDomain(chatConversation);
    }
}
