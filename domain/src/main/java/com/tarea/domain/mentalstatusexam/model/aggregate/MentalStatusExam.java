package com.tarea.domain.mentalstatusexam.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamDeletedEvent;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamRegisteredEvent;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamUpdatedEvent;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class MentalStatusExam extends AggregateRoot {

    private final MentalStatusExamId id;
    private EncounterId encounterId;
    private String appearance;
    private String behavior;
    private String attitude;
    private String consciousness;
    private String orientation;
    private String attention;
    private String memory;
    private String speech;
    private String mood;
    private String affect;
    private String thoughtProcess;
    private String thoughtContent;
    private String perception;
    private String judgment;
    private String insight;
    private String psychomotorActivity;
    private String observations;
    private final LocalDateTime createdAt;
    private final ProfessionalId createdBy;

    private MentalStatusExam(
            MentalStatusExamId id,
            EncounterId encounterId,
            String appearance,
            String behavior,
            String attitude,
            String consciousness,
            String orientation,
            String attention,
            String memory,
            String speech,
            String mood,
            String affect,
            String thoughtProcess,
            String thoughtContent,
            String perception,
            String judgment,
            String insight,
            String psychomotorActivity,
            String observations,
            LocalDateTime createdAt,
            ProfessionalId createdBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.createdBy = Objects.requireNonNull(createdBy, "createdBy must not be null");
    }

    public static MentalStatusExam register(
            EncounterId encounterId,
            String appearance,
            String behavior,
            String attitude,
            String consciousness,
            String orientation,
            String attention,
            String memory,
            String speech,
            String mood,
            String affect,
            String thoughtProcess,
            String thoughtContent,
            String perception,
            String judgment,
            String insight,
            String psychomotorActivity,
            String observations,
            ProfessionalId createdBy) {
        MentalStatusExamId id = MentalStatusExamId.generate();
        MentalStatusExam mentalStatusExam = new MentalStatusExam(
                id,
                encounterId,
                appearance,
                behavior,
                attitude,
                consciousness,
                orientation,
                attention,
                memory,
                speech,
                mood,
                affect,
                thoughtProcess,
                thoughtContent,
                perception,
                judgment,
                insight,
                psychomotorActivity,
                observations,
                LocalDateTime.now(),
                createdBy);
        mentalStatusExam.recordEvent(new MentalStatusExamRegisteredEvent(id, LocalDateTime.now()));
        return mentalStatusExam;
    }

    public static MentalStatusExam restore(
            MentalStatusExamId id,
            EncounterId encounterId,
            String appearance,
            String behavior,
            String attitude,
            String consciousness,
            String orientation,
            String attention,
            String memory,
            String speech,
            String mood,
            String affect,
            String thoughtProcess,
            String thoughtContent,
            String perception,
            String judgment,
            String insight,
            String psychomotorActivity,
            String observations,
            LocalDateTime createdAt,
            ProfessionalId createdBy) {
        return new MentalStatusExam(
                id,
                encounterId,
                appearance,
                behavior,
                attitude,
                consciousness,
                orientation,
                attention,
                memory,
                speech,
                mood,
                affect,
                thoughtProcess,
                thoughtContent,
                perception,
                judgment,
                insight,
                psychomotorActivity,
                observations,
                createdAt,
                createdBy);
    }

    public void update(
            EncounterId encounterId,
            String appearance,
            String behavior,
            String attitude,
            String consciousness,
            String orientation,
            String attention,
            String memory,
            String speech,
            String mood,
            String affect,
            String thoughtProcess,
            String thoughtContent,
            String perception,
            String judgment,
            String insight,
            String psychomotorActivity,
            String observations) {
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        recordEvent(new MentalStatusExamUpdatedEvent(
                id,
                this.encounterId,
                this.appearance,
                this.behavior,
                this.attitude,
                this.consciousness,
                this.orientation,
                this.attention,
                this.memory,
                this.speech,
                this.mood,
                this.affect,
                this.thoughtProcess,
                this.thoughtContent,
                this.perception,
                this.judgment,
                this.insight,
                this.psychomotorActivity,
                this.observations,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new MentalStatusExamDeletedEvent(id, LocalDateTime.now()));
    }

    public MentalStatusExamId id() {
        return id;
    }

    public EncounterId encounterId() {
        return encounterId;
    }

    public String appearance() {
        return appearance;
    }

    public String behavior() {
        return behavior;
    }

    public String attitude() {
        return attitude;
    }

    public String consciousness() {
        return consciousness;
    }

    public String orientation() {
        return orientation;
    }

    public String attention() {
        return attention;
    }

    public String memory() {
        return memory;
    }

    public String speech() {
        return speech;
    }

    public String mood() {
        return mood;
    }

    public String affect() {
        return affect;
    }

    public String thoughtProcess() {
        return thoughtProcess;
    }

    public String thoughtContent() {
        return thoughtContent;
    }

    public String perception() {
        return perception;
    }

    public String judgment() {
        return judgment;
    }

    public String insight() {
        return insight;
    }

    public String psychomotorActivity() {
        return psychomotorActivity;
    }

    public String observations() {
        return observations;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public ProfessionalId createdBy() {
        return createdBy;
    }
}
