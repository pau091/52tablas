package com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories;

import com.tarea.domain.phonecontact.model.aggregate.PhoneContact;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class PhoneContactRepositoryAdapter implements PhoneContactRepository {

    private final PhoneContactJpaRepository phoneContactJpaRepository;
    private final PhoneContactPersistenceMapper mapper;

    public PhoneContactRepositoryAdapter(PhoneContactJpaRepository phoneContactJpaRepository, PhoneContactPersistenceMapper mapper) {
        this.phoneContactJpaRepository = phoneContactJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PhoneContact save(PhoneContact phoneContact) {
        return mapper.toDomain(phoneContactJpaRepository.save(mapper.toJpa(phoneContact)));
    }

    @Override
    public Optional<PhoneContact> findById(PhoneContactId id) {
        return phoneContactJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PhoneContact> findAll() {
        return phoneContactJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PhoneContact phoneContact) {
        phoneContactJpaRepository.deleteById(phoneContact.id().value());
    }
}
