package com.github.jlgrock.snp.domain.types;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * The patient and all of the immediate metadata about the patient.
 */
public class Patient extends AbstractMongoDomainObject {

    private String firstName;

    private String middleName;

    private String lastName;

    @Pattern(regexp="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d")
    private LocalDate dateOfBirth;

    private Gender gender;
    
    private Boolean isDeceased;
    
    private LocalDate dateDeceased;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient that = (Patient) o;

        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(firstName, that.firstName) &&
                Objects.equal(middleName, that.middleName) &&
                Objects.equal(lastName, that.lastName) &&
                Objects.equal(dateOfBirth, that.dateOfBirth) &&
                Objects.equal(gender, that.gender) &&
                Objects.equal(isDeceased, that.isDeceased) &&
                Objects.equal(dateDeceased, that.dateDeceased);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                getId(),
                firstName,
                middleName,
                lastName,
                dateOfBirth,
                gender,
                isDeceased,
                dateDeceased);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("firstName", firstName)
                .add("middleName", middleName)
                .add("lastName", lastName)
                .add("dateOfBirth", dateOfBirth)
                .add("gender", gender)
                .add("isDeceased", isDeceased)
                .add("dateDeceased", dateDeceased)
                .toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String pFirstName) {
        firstName = pFirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String pMiddleName) {
        middleName = pMiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String pLastName) {
        lastName = pLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate pDateOfBirth) {
        dateOfBirth = pDateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender pGender) {
        gender = pGender;
    }

	public Boolean isDeceased() {
		return isDeceased;
	}

	public void setDeceased(final Boolean isDeceasedIn) {
		this.isDeceased = isDeceasedIn;
	}

	public LocalDate getDateDeceased() {
		return dateDeceased;
	}

	public void setDateDeceased(final LocalDate dateDeceasedIn) {
		this.dateDeceased = dateDeceasedIn;
	}
}

