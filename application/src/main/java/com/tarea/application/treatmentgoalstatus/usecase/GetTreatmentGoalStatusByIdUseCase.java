package com.tarea.application.treatmentgoalstatus.usecase;

import com.tarea.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.tarea.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class GetTreatmentGoalStatusByIdUseCase {

    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public GetTreatmentGoalStatusByIdUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalStatusResponse execute(TreatmentGoalStatusId id) {
        var treatmentGoalStatus = treatmentGoalStatusRepository.findById(id)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(id.value().toString()));
        return TreatmentGoalStatusResponse.fromDomain(treatmentGoalStatus);
    }
}
