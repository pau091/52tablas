package com.tarea.application.contact.usecase;

import com.tarea.application.contact.dto.ContactResponse;
import com.tarea.domain.contact.port.repository.ContactRepository;

import java.util.List;

public class ListContactUseCase {

    private final ContactRepository contactRepository;

    public ListContactUseCase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactResponse> execute() {
        return contactRepository.findAll().stream()
                .map(ContactResponse::fromDomain)
                .toList();
    }
}
