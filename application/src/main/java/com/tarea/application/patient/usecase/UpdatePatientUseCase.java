package com.tarea.application.patient.usecase;

import com.tarea.application.patient.command.UpdatePatientCommand;
import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.application.patient.exception.PatientNotFoundApplicationException;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class UpdatePatientUseCase {

    private final PatientRepository patientRepository;

    public UpdatePatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(UpdatePatientCommand command) {
        var patient = patientRepository.findById(command.id())
                .orElseThrow(() -> new PatientNotFoundApplicationException(command.id().value().toString()));
        patient.update(
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
                command.updatedBy(),
                command.cityId());
        var updated = patientRepository.save(patient);
        return PatientResponse.fromDomain(updated);
    }
}
