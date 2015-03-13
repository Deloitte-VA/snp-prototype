package com.github.jlgrock.snp.core.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * The patient and all of the immediate metadata about the patient.
 */
public class Patient {
    @NotNull
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    @Pattern(regexp="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d")
    private LocalDate dateOfBirth;

    private Gender gender;

    private Race race;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient that = (Patient) o;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.firstName, that.firstName) &&
                Objects.equal(this.middleName, that.middleName) &&
                Objects.equal(this.lastName, that.lastName) &&
                Objects.equal(this.dateOfBirth, that.dateOfBirth) &&
                Objects.equal(this.gender, that.gender) &&
                Objects.equal(this.race, that.race);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                id,
                firstName,
                middleName,
                lastName,
                dateOfBirth,
                gender,
                race);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("middleName", middleName)
                .add("lastName", lastName)
                .add("dateOfBirth", dateOfBirth)
                .add("gender", gender)
                .add("race", race)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long pId) {
        this.id = pId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String pFirstName) {
        this.firstName = pFirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String pMiddleName) {
        this.middleName = pMiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String pLastName) {
        this.lastName = pLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate pDateOfBirth) {
        this.dateOfBirth = pDateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender pGender) {
        this.gender = pGender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(final Race pRace) {
        this.race = pRace;
    }
}

