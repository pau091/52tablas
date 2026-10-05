package com.tarea.domain.professionalstudy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalStudyUpdatedEvent(
        ProfessionalStudyId id,
        StudyId studyId,
        ProfessionalId professionalId,
        String title,
        String university,
        Boolean isValid,
        String resolutionNumber,
        CountryId countryId,
        LocalDateTime occurredOn
) implements DomainEvent {

    public ProfessionalStudyUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}
