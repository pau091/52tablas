package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.command.RegisterChatParticipantCommand;
import com.tarea.application.chatparticipant.dto.ChatParticipantResponse;
import com.tarea.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class RegisterChatParticipantUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public RegisterChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public ChatParticipantResponse execute(RegisterChatParticipantCommand command) {
        ChatParticipant chatParticipant = ChatParticipant.register(
                command.conversationId(),
                command.participantTypeId(),
                command.patientId(),
                command.professionalId());
        ChatParticipant saved = chatParticipantRepository.save(chatParticipant);
        return ChatParticipantResponse.fromDomain(saved);
    }
}
