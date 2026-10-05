package com.tarea.domain.riskassessment.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.riskassessment.event.RiskAssessmentDeletedEvent;
import com.tarea.domain.riskassessment.event.RiskAssessmentRegisteredEvent;
import com.tarea.domain.riskassessment.event.RiskAssessmentUpdatedEvent;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public class RiskAssessment extends AggregateRoot {

    private final RiskAssessmentId id;
    private EncounterId encounterId;
    private RiskLevelId riskLevelId;
    private Boolean suicidalIdeation;
    private Boolean suicidePlan;
    private Boolean suicideIntent;
    private Boolean selfHarm;
    private Boolean harmToOthers;
    private String riskFactors;
    private String protectiveFactors;
    private String clinicalActions;
    private String observations;
    private LocalDateTime assessedAt;
    private ProfessionalId assessedBy;

    private RiskAssessment(
            RiskAssessmentId id,
            EncounterId encounterId,
            RiskLevelId riskLevelId,
            Boolean suicidalIdeation,
            Boolean suicidePlan,
            Boolean suicideIntent,
            Boolean selfHarm,
            Boolean harmToOthers,
            String riskFactors,
            String protectiveFactors,
            String clinicalActions,
            String observations,
            LocalDateTime assessedAt,
            ProfessionalId assessedBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.riskLevelId = Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.riskFactors = riskFactors;
        this.protectiveFactors = protectiveFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = Objects.requireNonNull(assessedBy, "assessedBy must not be null");
    }

    public static RiskAssessment register(
            EncounterId encounterId,
            RiskLevelId riskLevelId,
            Boolean suicidalIdeation,
            Boolean suicidePlan,
            Boolean suicideIntent,
            Boolean selfHarm,
            Boolean harmToOthers,
            String riskFactors,
            String protectiveFactors,
            String clinicalActions,
            String observations,
            LocalDateTime assessedAt,
            ProfessionalId assessedBy) {
        RiskAssessmentId id = RiskAssessmentId.generate();
        RiskAssessment riskAssessment = new RiskAssessment(
                id,
                encounterId,
                riskLevelId,
                suicidalIdeation != null ? suicidalIdeation : Boolean.FALSE,
                suicidePlan != null ? suicidePlan : Boolean.FALSE,
                suicideIntent != null ? suicideIntent : Boolean.FALSE,
                selfHarm != null ? selfHarm : Boolean.FALSE,
                harmToOthers != null ? harmToOthers : Boolean.FALSE,
                riskFactors,
                protectiveFactors,
                clinicalActions,
                observations,
                assessedAt,
                assessedBy);
        riskAssessment.recordEvent(new RiskAssessmentRegisteredEvent(id, LocalDateTime.now()));
        return riskAssessment;
    }

    public static RiskAssessment restore(
            RiskAssessmentId id,
            EncounterId encounterId,
            RiskLevelId riskLevelId,
            Boolean suicidalIdeation,
            Boolean suicidePlan,
            Boolean suicideIntent,
            Boolean selfHarm,
            Boolean harmToOthers,
            String riskFactors,
            String protectiveFactors,
            String clinicalActions,
            String observations,
            LocalDateTime assessedAt,
            ProfessionalId assessedBy) {
        return new RiskAssessment(
                id,
                encounterId,
                riskLevelId,
                suicidalIdeation,
                suicidePlan,
                suicideIntent,
                selfHarm,
                harmToOthers,
                riskFactors,
                protectiveFactors,
                clinicalActions,
                observations,
                assessedAt,
                assessedBy);
    }

    public void update(
            EncounterId encounterId,
            RiskLevelId riskLevelId,
            Boolean suicidalIdeation,
            Boolean suicidePlan,
            Boolean suicideIntent,
            Boolean selfHarm,
            Boolean harmToOthers,
            String riskFactors,
            String protectiveFactors,
            String clinicalActions,
            String observations,
            LocalDateTime assessedAt,
            ProfessionalId assessedBy) {
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.riskLevelId = Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.riskFactors = riskFactors;
        this.protectiveFactors = protectiveFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = Objects.requireNonNull(assessedBy, "assessedBy must not be null");
        recordEvent(new RiskAssessmentUpdatedEvent(
                id,
                this.encounterId,
                this.riskLevelId,
                this.suicidalIdeation,
                this.suicidePlan,
                this.suicideIntent,
                this.selfHarm,
                this.harmToOthers,
                this.riskFactors,
                this.protectiveFactors,
                this.clinicalActions,
                this.observations,
                this.assessedAt,
                this.assessedBy,
                LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new RiskAssessmentDeletedEvent(id, LocalDateTime.now()));
    }

    public RiskAssessmentId id() {
        return id;
    }

    public EncounterId encounterId() {
        return encounterId;
    }

    public RiskLevelId riskLevelId() {
        return riskLevelId;
    }

    public Boolean suicidalIdeation() {
        return suicidalIdeation;
    }

    public Boolean suicidePlan() {
        return suicidePlan;
    }

    public Boolean suicideIntent() {
        return suicideIntent;
    }

    public Boolean selfHarm() {
        return selfHarm;
    }

    public Boolean harmToOthers() {
        return harmToOthers;
    }

    public String riskFactors() {
        return riskFactors;
    }

    public String protectiveFactors() {
        return protectiveFactors;
    }

    public String clinicalActions() {
        return clinicalActions;
    }

    public String observations() {
        return observations;
    }

    public LocalDateTime assessedAt() {
        return assessedAt;
    }

    public ProfessionalId assessedBy() {
        return assessedBy;
    }
}
