package com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories;

import com.tarea.domain.documenttype.model.aggregate.DocumentType;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.mappers.DocumentTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class DocumentTypeRepositoryAdapter implements DocumentTypeRepository {

    private final DocumentTypeJpaRepository documentTypeJpaRepository;
    private final DocumentTypePersistenceMapper mapper;

    public DocumentTypeRepositoryAdapter(DocumentTypeJpaRepository documentTypeJpaRepository, DocumentTypePersistenceMapper mapper) {
        this.documentTypeJpaRepository = documentTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public DocumentType save(DocumentType documentType) {
        return mapper.toDomain(documentTypeJpaRepository.save(mapper.toJpa(documentType)));
    }

    @Override
    public Optional<DocumentType> findById(DocumentTypeId id) {
        return documentTypeJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<DocumentType> findAll() {
        return documentTypeJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(DocumentType documentType) {
        documentTypeJpaRepository.deleteById(documentType.id().value());
    }
}
