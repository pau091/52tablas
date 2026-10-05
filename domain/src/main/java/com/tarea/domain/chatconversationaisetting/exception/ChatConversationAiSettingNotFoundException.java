package com.tarea.domain.chatconversationaisetting.exception;

public class ChatConversationAiSettingNotFoundException extends RuntimeException {

    public ChatConversationAiSettingNotFoundException(String id) {
        super("ChatConversationAiSetting not found with id: " + id);
    }
}
