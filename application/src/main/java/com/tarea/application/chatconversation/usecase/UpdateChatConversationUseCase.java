package com.tarea.application.chatconversation.usecase;

import com.tarea.application.chatconversation.command.UpdateChatConversationCommand;
import com.tarea.application.chatconversation.dto.ChatConversationResponse;
import com.tarea.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;

public class UpdateChatConversationUseCase {

    private final ChatConversationRepository chatConversationRepository;

    public UpdateChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    public ChatConversationResponse execute(UpdateChatConversationCommand command) {
        var chatConversation = chatConversationRepository.findById(command.id())
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(command.id().value().toString()));
        chatConversation.update(
                command.conversationStatusId(),
                command.priorityId(),
                command.lastMessageAt(),
                command.closed(),
                command.closedAt(),
                command.closedBy());
        var updated = chatConversationRepository.save(chatConversation);
        return ChatConversationResponse.fromDomain(updated);
    }
}
