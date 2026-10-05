package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.dto.EmailContactResponse;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

import java.util.List;

public class ListEmailContactUseCase {

    private final EmailContactRepository emailContactRepository;

    public ListEmailContactUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public List<EmailContactResponse> execute() {
        return emailContactRepository.findAll().stream()
                .map(EmailContactResponse::fromDomain)
                .toList();
    }
}
