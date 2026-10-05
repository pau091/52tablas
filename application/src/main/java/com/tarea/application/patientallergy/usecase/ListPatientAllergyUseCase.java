package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

import java.util.List;

public class ListPatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public ListPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public List<PatientAllergyResponse> execute() {
        return patientAllergyRepository.findAll().stream()
                .map(PatientAllergyResponse::fromDomain)
                .toList();
    }
}
