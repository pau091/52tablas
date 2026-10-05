package com.tarea.domain.professionalstudy.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyDeletedEvent;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyRegisteredEvent;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyUpdatedEvent;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProfessionalStudy extends AggregateRoot {

    private final ProfessionalStudyId id;
    private StudyId studyId;
    private ProfessionalId professionalId;
    private String title;
    private String university;
    private Boolean isValid;
    private String resolutionNumber;
    private CountryId countryId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProfessionalStudy(
            ProfessionalStudyId id,
            StudyId studyId,
            ProfessionalId professionalId,
            String title,
            String university,
            Boolean isValid,
            String resolutionNumber,
            CountryId countryId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.studyId = Objects.requireNonNull(studyId, "studyId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = title;
        this.university = university;
        this.isValid = isValid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = Objects.requireNonNull(countryId, "countryId must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ProfessionalStudy register(
            StudyId studyId,
            ProfessionalId professionalId,
            String title,
            String university,
            Boolean isValid,
            String resolutionNumber,
            CountryId countryId) {
        ProfessionalStudyId id = ProfessionalStudyId.generate();
        ProfessionalStudy professionalStudy = new ProfessionalStudy(
                id,
                studyId,
                professionalId,
                title,
                university,
                isValid != null ? isValid : Boolean.FALSE,
                resolutionNumber,
                countryId,
                LocalDateTime.now(),
                null);
        professionalStudy.recordEvent(new ProfessionalStudyRegisteredEvent(id, LocalDateTime.now()));
        return professionalStudy;
    }

    public static ProfessionalStudy restore(
            ProfessionalStudyId id,
            StudyId studyId,
            ProfessionalId professionalId,
            String title,
            String university,
            Boolean isValid,
            String resolutionNumber,
            CountryId countryId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ProfessionalStudy(
                id,
                studyId,
                professionalId,
                title,
                university,
                isValid,
                resolutionNumber,
                countryId,
                createdAt,
                updatedAt);
    }

    public void update(
            StudyId studyId,
            ProfessionalId professionalId,
            String title,
            String university,
            Boolean isValid,
            String resolutionNumber,
            CountryId countryId) {
        this.studyId = Objects.requireNonNull(studyId, "studyId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = title;
        this.university = university;
        this.isValid = isValid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = Objects.requireNonNull(countryId, "countryId must not be null");
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProfessionalStudyUpdatedEvent(
                id,
                this.studyId,
                this.professionalId,
                this.title,
                this.university,
                this.isValid,
                this.resolutionNumber,
                this.countryId,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalStudyDeletedEvent(id, LocalDateTime.now()));
    }

    public ProfessionalStudyId id() {
        return id;
    }

    public StudyId studyId() {
        return studyId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public String title() {
        return title;
    }

    public String university() {
        return university;
    }

    public Boolean isValid() {
        return isValid;
    }

    public String resolutionNumber() {
        return resolutionNumber;
    }

    public CountryId countryId() {
        return countryId;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
