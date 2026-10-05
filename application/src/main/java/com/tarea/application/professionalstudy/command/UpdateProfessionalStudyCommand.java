package com.tarea.application.professionalstudy.command;

import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.study.model.valueobject.StudyId;

public record UpdateProfessionalStudyCommand(
        ProfessionalStudyId id,
        StudyId studyId,
        ProfessionalId professionalId,
        String title,
        String university,
        Boolean isValid,
        String resolutionNumber,
        CountryId countryId
) {
}
