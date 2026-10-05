package com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories;

import com.tarea.domain.patientcontact.model.aggregate.PatientContact;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class PatientContactRepositoryAdapter implements PatientContactRepository {

    private final PatientContactJpaRepository patientContactJpaRepository;
    private final PatientContactPersistenceMapper mapper;

    public PatientContactRepositoryAdapter(PatientContactJpaRepository patientContactJpaRepository, PatientContactPersistenceMapper mapper) {
        this.patientContactJpaRepository = patientContactJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientContact save(PatientContact patientContact) {
        return mapper.toDomain(patientContactJpaRepository.save(mapper.toJpa(patientContact)));
    }

    @Override
    public Optional<PatientContact> findById(PatientContactId id) {
        return patientContactJpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PatientContact> findAll() {
        return patientContactJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PatientContact patientContact) {
        patientContactJpaRepository.deleteById(patientContact.id().value());
    }
}
