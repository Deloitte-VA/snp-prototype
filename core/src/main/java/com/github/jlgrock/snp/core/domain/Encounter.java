package com.github.jlgrock.snp.core.domain;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The domain object that represents a single encounter in a patient visit.  Each encounter can consist
 * of multiple {@link com.github.jlgrock.snp.core.domain.Observation Observation} objects.
 */
public class Encounter extends AbstractMongoDomainObject {

    @NotNull
    private Long patientId;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("patientId", patientId)
                .add("date", date)
                .add("type", type)
                .add("reasonForVisit", reasonForVisit)
                .add("observations", observations)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), patientId, date, type, reasonForVisit, observations);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Encounter other = (Encounter) obj;
        return Objects.equals(this.getId(), other.getId())
                && Objects.equals(this.patientId, other.patientId)
                && Objects.equals(this.date, other.date)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.reasonForVisit, other.reasonForVisit)
                && Objects.equals(this.observations, other.observations);
    }

    @NotNull
    private LocalDate date;

    private Integer type;

    private String reasonForVisit;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate pDate) {
        date = pDate;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(final String pReasonForVisit) {
        reasonForVisit = pReasonForVisit;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(final List<Observation> pObservations) {
        observations = pObservations;
    }

    public Integer getType() {
        return type;
    }

    public void setType(final Integer pType) {
        type = pType;
    }

    private List<Observation> observations;

    public Long getPatientId() {
        return patientId;
    }

	public void setPatientId(final Long pPatientId) {
        this.patientId = pPatientId;
    }
}

