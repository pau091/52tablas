package com.tarea.application.patient.usecase;

import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.domain.patient.port.repository.PatientRepository;

import java.util.List;

public class ListPatientsUseCase {

    private final PatientRepository patientRepository;

    public ListPatientsUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponse> execute() {
        return patientRepository.findAll().stream()
                .map(PatientResponse::fromDomain)
                .toList();
    }
}
