package com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories;

import com.tarea.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.mappers.EscalationStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EscalationStatusRepositoryAdapter implements EscalationStatusRepository {

    private final EscalationStatusJpaRepository escalationStatusJpaRepository;
    private final EscalationStatusPersistenceMapper mapper;

    public EscalationStatusRepositoryAdapter(EscalationStatusJpaRepository escalationStatusJpaRepository, EscalationStatusPersistenceMapper mapper) {
        this.escalationStatusJpaRepository = escalationStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EscalationStatus save(EscalationStatus escalationStatus) {
        return mapper.toDomain(escalationStatusJpaRepository.save(mapper.toJpa(escalationStatus)));
    }

    @Override
    public Optional<EscalationStatus> findById(EscalationStatusId id) {
        return escalationStatusJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EscalationStatus> findAll() {
        return escalationStatusJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EscalationStatus escalationStatus) {
        escalationStatusJpaRepository.deleteById(escalationStatus.id().value());
    }
}
