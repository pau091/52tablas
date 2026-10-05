package com.tarea.infrastructure.patientallergy.adapters.out.persistence.mappers;

import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;

public class PatientAllergyPersistenceMapper {

    public PatientAllergyJpaEntity toJpa(PatientAllergy domain) {
        if (domain == null) return null;
        PatientAllergyJpaEntity jpa = new PatientAllergyJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setPatientId(domain.patientId().value());
        jpa.setSubstance(domain.substance());
        jpa.setReaction(domain.reaction());
        jpa.setSeverity(domain.severity());
        jpa.setActive(domain.active());
        jpa.setRecordedAt(domain.recordedAt());
        jpa.setRecordedBy(domain.recordedBy());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public PatientAllergy toDomain(PatientAllergyJpaEntity jpa) {
        if (jpa == null) return null;
        return PatientAllergy.restore(
                new PatientAllergyId(jpa.getId()),
                new PatientId(jpa.getPatientId()),
                jpa.getSubstance(),
                jpa.getReaction(),
                jpa.getSeverity(),
                jpa.getActive(),
                jpa.getRecordedAt(),
                jpa.getRecordedBy(),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
