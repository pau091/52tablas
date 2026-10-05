package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class GetPatientAllergyByIdUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public GetPatientAllergyByIdUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public PatientAllergyResponse execute(PatientAllergyId id) {
        var patientAllergy = patientAllergyRepository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id.value().toString()));
        return PatientAllergyResponse.fromDomain(patientAllergy);
    }
}
