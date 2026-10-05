package com.tarea.application.chatconversationaisetting.usecase;

import com.tarea.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

import java.util.List;

public class ListChatConversationAiSettingUseCase {

    private final ChatConversationAiSettingRepository chatConversationAiSettingRepository;

    public ListChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        this.chatConversationAiSettingRepository = chatConversationAiSettingRepository;
    }

    public List<ChatConversationAiSettingResponse> execute() {
        return chatConversationAiSettingRepository.findAll().stream()
                .map(ChatConversationAiSettingResponse::fromDomain)
                .toList();
    }
}
