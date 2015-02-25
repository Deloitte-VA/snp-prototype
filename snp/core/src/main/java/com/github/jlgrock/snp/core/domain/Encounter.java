package com.github.jlgrock.snp.core.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The domain object that represents a single encounter in a patient visit.  Each encounter can consist
 * of multiple {@link com.github.jlgrock.snp.core.domain.Observation Observation} objects.
 */
@Document(collection = "encounters")
public class Encounter {
    @Id
    private Long id;

    @NotNull
    private Patient patient;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encounter encounter = (Encounter) o;

        if (date != null ? !date.equals(encounter.date) : encounter.date != null) return false;
        if (id != null ? !id.equals(encounter.id) : encounter.id != null) return false;
        if (reasonForVisit != null ? !reasonForVisit.equals(encounter.reasonForVisit) : encounter.reasonForVisit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (reasonForVisit != null ? reasonForVisit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +

                ", date=" + date +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                '}';
    }

    @NotNull
    private DateTime date;

    private Integer type;

    @Field(value = "reason_for_visit")
    private String reasonForVisit;

    public DateTime getDate() {
        return date;
    }

    public void setDate(final DateTime pdate) {
        this.date = pdate;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(final String preasonForVisit) {
        this.reasonForVisit = preasonForVisit;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(final List<Observation> pobservations) {
        this.observations = pobservations;
    }

    public Integer getType() {
        return type;
    }

    public void setType(final Integer ptype) {
        this.type = ptype;
    }

    private List<Observation> observations;

    public void setId(final Long pid) {
        this.id = pid;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(final Patient ppatient) {
        this.patient = ppatient;
    }
}

