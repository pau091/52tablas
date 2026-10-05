package com.tarea.application.patient.usecase;

import com.tarea.application.patient.command.RegisterPatientCommand;
import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.domain.patient.model.aggregate.Patient;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class RegisterPatientUseCase {

    private final PatientRepository patientRepository;

    public RegisterPatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(RegisterPatientCommand command) {
        Patient patient = Patient.register(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                command.birthDate(),
                command.biologicalSexId(),
                command.genderIdentity(),
                command.email(),
                command.phone(),
                command.address(),
                command.active(),
                command.createdBy(),
                command.updatedBy(),
                command.cityId());
        Patient saved = patientRepository.save(patient);
        return PatientResponse.fromDomain(saved);
    }
}
