package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class RegisterPatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public RegisterPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public PatientAllergyResponse execute(RegisterPatientAllergyCommand command) {
        PatientAllergy patientAllergy = PatientAllergy.register(
                command.patientId(),
                command.substance(),
                command.reaction(),
                command.severity(),
                command.active(),
                command.recordedAt(),
                command.recordedBy());
        PatientAllergy saved = patientAllergyRepository.save(patientAllergy);
        return PatientAllergyResponse.fromDomain(saved);
    }
}
