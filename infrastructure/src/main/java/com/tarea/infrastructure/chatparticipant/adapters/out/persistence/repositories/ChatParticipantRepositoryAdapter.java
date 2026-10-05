package com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import com.tarea.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatParticipantRepositoryAdapter implements ChatParticipantRepository {

    private final ChatParticipantJpaRepository chatParticipantJpaRepository;
    private final ChatParticipantPersistenceMapper mapper;

    public ChatParticipantRepositoryAdapter(ChatParticipantJpaRepository chatParticipantJpaRepository, ChatParticipantPersistenceMapper mapper) {
        this.chatParticipantJpaRepository = chatParticipantJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatParticipant save(ChatParticipant chatParticipant) {
        return mapper.toDomain(chatParticipantJpaRepository.save(mapper.toJpa(chatParticipant)));
    }

    @Override
    public Optional<ChatParticipant> findById(ChatParticipantId id) {
        return chatParticipantJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatParticipant> findAll() {
        return chatParticipantJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatParticipant chatParticipant) {
        chatParticipantJpaRepository.deleteById(chatParticipant.id().value());
    }
}
