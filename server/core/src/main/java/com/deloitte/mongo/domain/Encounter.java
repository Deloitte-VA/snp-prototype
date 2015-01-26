package com.deloitte.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Document(collection = "encounters")
public class Encounter {
    @Id
    private Long id;

    @NotNull
    private Patient patient;

    @Override
    public boolean equals(Object o) {
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
    private Date date;

    private Integer type;

    @Field(value = "reason_for_visit")
    private String reasonForVisit;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private List<Observation> observations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
