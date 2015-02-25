package com.github.jlgrock.snp.core.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jlgrock on 1/11/15.
 */
@Document(collection = "patients")
public class Patient {
    @Id
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private DateTime dateOfBirth;

    private Gender gender;

    private Race race;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (dateOfBirth != null ? !dateOfBirth.equals(patient.dateOfBirth) : patient.dateOfBirth != null) return false;
        if (firstName != null ? !firstName.equals(patient.firstName) : patient.firstName != null) return false;
        if (gender != patient.gender) return false;
        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;
        if (lastName != null ? !lastName.equals(patient.lastName) : patient.lastName != null) return false;
        if (middleName != null ? !middleName.equals(patient.middleName) : patient.middleName != null) return false;
        if (race != patient.race) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender.toString() +
                ", race=" + race +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long pid) {
        this.id = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String pfirstName) {
        this.firstName = pfirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String pmiddleName) {
        this.middleName = pmiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String plastName) {
        this.lastName = plastName;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final DateTime pdateOfBirth) {
        this.dateOfBirth = pdateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender pgender) {
        this.gender = pgender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(final Race prace) {
        this.race = prace;
    }
}

