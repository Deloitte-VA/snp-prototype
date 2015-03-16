package com.github.jlgrock.snp.core.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * The domain object that represents a single encounter in a patient visit.  Each encounter can consist
 * of multiple {@link com.github.jlgrock.snp.core.domain.Observation Observation} objects.
 */
public class Encounter {
    @NotNull
    private Long id;

    @NotNull
    private Long patientId;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encounter that = (Encounter) o;

        return Objects.equal(id, that.id) &&
                Objects.equal(patientId, that.patientId) &&
                Objects.equal(date, that.date) &&
                Objects.equal(type, that.type) &&
                Objects.equal(reasonForVisit, that.reasonForVisit) &&
                Objects.equal(observations, that.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, patientId, date, type, reasonForVisit, observations);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("patientId", patientId)
                .add("date", date)
                .add("type", type)
                .add("reasonForVisit", reasonForVisit)
                .add("observations", observations)
                .toString();
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

    public void setId(final Long pId) {
        id = pId;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

	public void setPatientId(final Long pPatientId) {
        this.patientId = pPatientId;
    }
}

