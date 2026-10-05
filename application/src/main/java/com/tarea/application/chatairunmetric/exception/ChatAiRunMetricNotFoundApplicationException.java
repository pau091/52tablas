package com.tarea.application.chatairunmetric.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunMetricNotFoundApplicationException extends ApplicationException {

    public ChatAiRunMetricNotFoundApplicationException(String id) {
        super("ChatAiRunMetric not found with id: " + id);
    }
}
