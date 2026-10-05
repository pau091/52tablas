package com.tarea.domain.chatparticipant.exception;

public class ChatParticipantNotFoundException extends RuntimeException {

    public ChatParticipantNotFoundException(String id) {
        super("ChatParticipant not found with id: " + id);
    }
}
