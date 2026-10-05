package com.tarea.domain.clinicalnote.model.aggregate;

import com.tarea.domain.clinicalnote.event.ClinicalNoteDeletedEvent;
import com.tarea.domain.clinicalnote.event.ClinicalNoteRegisteredEvent;
import com.tarea.domain.clinicalnote.event.ClinicalNoteUpdatedEvent;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalNote extends AggregateRoot {

    private final ClinicalNoteId id;
    private EncounterId encounterId;
    private ProfessionalId professionalId;
    private String subjective;
    private String objective;
    private String assessment;
    private String plan;
    private String additionalNotes;
    private LocalDateTime signedAt;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalNote(
            ClinicalNoteId id,
            EncounterId encounterId,
            ProfessionalId professionalId,
            String subjective,
            String objective,
            String assessment,
            String plan,
            String additionalNotes,
            LocalDateTime signedAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = updatedAt;
    }

    public static ClinicalNote register(
            EncounterId encounterId,
            ProfessionalId professionalId,
            String subjective,
            String objective,
            String assessment,
            String plan,
            String additionalNotes,
            LocalDateTime signedAt) {
        ClinicalNoteId id = ClinicalNoteId.generate();
        ClinicalNote clinicalNote = new ClinicalNote(
                id,
                encounterId,
                professionalId,
                subjective,
                objective,
                assessment,
                plan,
                additionalNotes,
                signedAt,
                LocalDateTime.now(),
                null);
        clinicalNote.recordEvent(new ClinicalNoteRegisteredEvent(id, LocalDateTime.now()));
        return clinicalNote;
    }

    public static ClinicalNote restore(
            ClinicalNoteId id,
            EncounterId encounterId,
            ProfessionalId professionalId,
            String subjective,
            String objective,
            String assessment,
            String plan,
            String additionalNotes,
            LocalDateTime signedAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new ClinicalNote(
                id,
                encounterId,
                professionalId,
                subjective,
                objective,
                assessment,
                plan,
                additionalNotes,
                signedAt,
                createdAt,
                updatedAt);
    }

    public void update(
            EncounterId encounterId,
            ProfessionalId professionalId,
            String subjective,
            String objective,
            String assessment,
            String plan,
            String additionalNotes,
            LocalDateTime signedAt) {
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ClinicalNoteUpdatedEvent(
                id,
                this.encounterId,
                this.professionalId,
                this.subjective,
                this.objective,
                this.assessment,
                this.plan,
                this.additionalNotes,
                this.signedAt,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalNoteDeletedEvent(id, LocalDateTime.now()));
    }

    public ClinicalNoteId id() {
        return id;
    }

    public EncounterId encounterId() {
        return encounterId;
    }

    public ProfessionalId professionalId() {
        return professionalId;
    }

    public String subjective() {
        return subjective;
    }

    public String objective() {
        return objective;
    }

    public String assessment() {
        return assessment;
    }

    public String plan() {
        return plan;
    }

    public String additionalNotes() {
        return additionalNotes;
    }

    public LocalDateTime signedAt() {
        return signedAt;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }
}
