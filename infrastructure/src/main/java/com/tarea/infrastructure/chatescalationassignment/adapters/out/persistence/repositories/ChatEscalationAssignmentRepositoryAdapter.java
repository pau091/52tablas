package com.tarea.infrastructure.chatescalationassignment.adapters.out.persistence.repositories;

import com.tarea.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.tarea.infrastructure.chatescalationassignment.adapters.out.persistence.mappers.ChatEscalationAssignmentPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatEscalationAssignmentRepositoryAdapter implements ChatEscalationAssignmentRepository {

    private final ChatEscalationAssignmentJpaRepository chatEscalationAssignmentJpaRepository;
    private final ChatEscalationAssignmentPersistenceMapper mapper;

    public ChatEscalationAssignmentRepositoryAdapter(ChatEscalationAssignmentJpaRepository chatEscalationAssignmentJpaRepository, ChatEscalationAssignmentPersistenceMapper mapper) {
        this.chatEscalationAssignmentJpaRepository = chatEscalationAssignmentJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalationAssignment save(ChatEscalationAssignment chatEscalationAssignment) {
        return mapper.toDomain(chatEscalationAssignmentJpaRepository.save(mapper.toJpa(chatEscalationAssignment)));
    }

    @Override
    public Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id) {
        return chatEscalationAssignmentJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalationAssignment> findAll() {
        return chatEscalationAssignmentJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatEscalationAssignment chatEscalationAssignment) {
        chatEscalationAssignmentJpaRepository.deleteById(chatEscalationAssignment.id().value());
    }
}
