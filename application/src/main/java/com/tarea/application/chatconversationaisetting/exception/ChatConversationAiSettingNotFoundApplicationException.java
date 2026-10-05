package com.tarea.application.chatconversationaisetting.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatConversationAiSettingNotFoundApplicationException extends ApplicationException {

    public ChatConversationAiSettingNotFoundApplicationException(String id) {
        super("ChatConversationAiSetting not found with id: " + id);
    }
}
