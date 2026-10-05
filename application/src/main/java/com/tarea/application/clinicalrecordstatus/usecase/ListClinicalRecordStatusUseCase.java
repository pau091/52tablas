package com.tarea.application.clinicalrecordstatus.usecase;

import com.tarea.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

import java.util.List;

public class ListClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public ListClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public List<ClinicalRecordStatusResponse> execute() {
        return clinicalRecordStatusRepository.findAll().stream()
                .map(ClinicalRecordStatusResponse::fromDomain)
                .toList();
    }
}
