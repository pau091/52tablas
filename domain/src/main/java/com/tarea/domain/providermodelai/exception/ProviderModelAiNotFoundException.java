package com.tarea.domain.providermodelai.exception;

public class ProviderModelAiNotFoundException extends RuntimeException {

    public ProviderModelAiNotFoundException(String id) {
        super("ProviderModelAi not found with id: " + id);
    }
}
