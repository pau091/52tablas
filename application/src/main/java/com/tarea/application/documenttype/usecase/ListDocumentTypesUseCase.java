package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.dto.DocumentTypeResponse;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

import java.util.List;

public class ListDocumentTypesUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public ListDocumentTypesUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public List<DocumentTypeResponse> execute() {
        return documentTypeRepository.findAll().stream()
                .map(DocumentTypeResponse::fromDomain)
                .toList();
    }
}
