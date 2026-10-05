package com.tarea.application.chatescalationstatushistory.usecase;

import com.tarea.application.chatescalationstatushistory.command.RegisterChatEscalationStatusHistoryCommand;
import com.tarea.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.tarea.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class RegisterChatEscalationStatusHistoryUseCase {

    private final ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository;

    public RegisterChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        this.chatEscalationStatusHistoryRepository = chatEscalationStatusHistoryRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(RegisterChatEscalationStatusHistoryCommand command) {
        ChatEscalationStatusHistory chatEscalationStatusHistory = ChatEscalationStatusHistory.register(command.escalationId(), command.escalationStatusId(), command.changedAt());
        ChatEscalationStatusHistory saved = chatEscalationStatusHistoryRepository.save(chatEscalationStatusHistory);
        return ChatEscalationStatusHistoryResponse.fromDomain(saved);
    }
}
