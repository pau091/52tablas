package com.tarea.domain.chatairunmetric.exception;

public class ChatAiRunMetricNotFoundException extends RuntimeException {

    public ChatAiRunMetricNotFoundException(String id) {
        super("ChatAiRunMetric not found with id: " + id);
    }
}
