package com.tarea.application.patient.usecase;

import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.application.patient.exception.PatientNotFoundApplicationException;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class GetPatientByIdUseCase {

    private final PatientRepository patientRepository;

    public GetPatientByIdUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(PatientId id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id.value().toString()));
        return PatientResponse.fromDomain(patient);
    }
}
