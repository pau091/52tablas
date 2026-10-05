package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.command.UpdateProviderModelAiCommand;
import com.tarea.application.providermodelai.dto.ProviderModelAiResponse;
import com.tarea.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class UpdateProviderModelAiUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public UpdateProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public ProviderModelAiResponse execute(UpdateProviderModelAiCommand command) {
        var providerModelAi = providerModelAiRepository.findById(command.id())
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(command.id().value().toString()));
        providerModelAi.update(
                command.nameProviderAi(),
                command.razonSocial(),
                command.sitioWeb(),
                command.isActive());
        var updated = providerModelAiRepository.save(providerModelAi);
        return ProviderModelAiResponse.fromDomain(updated);
    }
}
