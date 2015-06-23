package com.github.jlgrock.snp.domain.domain;

import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;


public class PatientTest {

    private Long pt1Id = new Long(201521L);
    private String pt1FirstName = "Brady";
    private String pt1MiddleName = "Wilson";
    private String pt1LastName = "Lynch";
    private LocalDate pt1Dob = LocalDate.of(1958, 2, 2);
    private Gender pt1Gender = Gender.MALE;
    private Boolean pt1IsDeceased = true;
    private LocalDate pt1DateDeceased = LocalDate.of(2015, 3, 24);

    private Long pt2Id = new Long(201523L);
    private String pt2FirstName = "Gronkowski";
    private String pt2MiddleName = "Amendola";
    private String pt2LastName = "Sherman";
    private LocalDate pt2Dob = LocalDate.of(1975, 2, 4);
    private Gender pt2Gender = Gender.FEMALE;
    private Boolean pt2IsDeceased = false;
    private String fhirId = "f202";

    @Test
    public void testSettersandGetters() {

        Patient pt1 = new Patient();

        pt1.setId(pt1Id);
        pt1.setFirstName(pt1FirstName);
        pt1.setMiddleName(pt1MiddleName);
        pt1.setLastName(pt1LastName);
        pt1.setDateOfBirth(pt1Dob);
        pt1.setGender(pt1Gender);
        pt1.setDeceased(pt1IsDeceased);
        pt1.setDateDeceased(pt1DateDeceased);

        assertEquals(pt1.getId(), pt1Id);
        assertEquals(pt1.getFirstName(), pt1FirstName);
        assertEquals(pt1.getMiddleName(), pt1MiddleName);
        assertEquals(pt1.getLastName(), pt1LastName);
        assertEquals(pt1.getDateOfBirth(), pt1Dob);
        assertEquals(pt1.getGender(), pt1Gender);
        assertEquals(pt1.isDeceased(), pt1IsDeceased);
        assertEquals(pt1.getDateDeceased(), pt1DateDeceased);
    }

    @Test
    public void testHashCodeAndEquals() {
        Patient pt1 = new Patient();

        pt1.setId(pt1Id);
        pt1.setFirstName(pt1FirstName);
        pt1.setMiddleName(pt1MiddleName);
        pt1.setLastName(pt1LastName);
        pt1.setDateOfBirth(pt1Dob);
        pt1.setGender(pt1Gender);
        pt1.setDeceased(pt1IsDeceased);
        pt1.setDateDeceased(pt1DateDeceased);

        Patient pt2 = new Patient();

        pt2.setId(pt1Id);
        pt2.setFirstName(pt1FirstName);
        pt2.setMiddleName(pt1MiddleName);
        pt2.setLastName(pt1LastName);
        pt2.setDateOfBirth(pt1Dob);
        pt2.setGender(pt1Gender);
        pt2.setDeceased(pt1IsDeceased);
        pt2.setDateDeceased(pt1DateDeceased);

        assertEquals(pt1.getId(), pt2.getId());
        assertEquals(pt1.getFirstName(), pt2.getFirstName());
        assertEquals(pt1.getMiddleName(), pt2.getMiddleName());
        assertEquals(pt1.getLastName(), pt2.getLastName());
        assertEquals(pt1.getDateOfBirth(), pt2.getDateOfBirth());
        assertEquals(pt1.getGender(), pt2.getGender());
        assertEquals(pt1.isDeceased(), pt2.isDeceased());
        assertEquals(pt1.getDateDeceased(), pt2.getDateDeceased());

        assertTrue(pt2.equals(pt1));
        assertEquals(pt1.hashCode(), pt2.hashCode());
    }

    @Test
    public void testHashCodeAndEqualsNegative() {
        Patient pt1 = new Patient();

        pt1.setId(pt1Id);
        pt1.setFirstName(pt1FirstName);
        pt1.setMiddleName(pt1MiddleName);
        pt1.setLastName(pt1LastName);
        pt1.setDateOfBirth(pt1Dob);
        pt1.setGender(pt1Gender);
        pt1.setDeceased(pt1IsDeceased);
        pt1.setDateDeceased(pt1DateDeceased);

        Patient pt2 = new Patient();

        pt2.setId(pt2Id);
        pt2.setFirstName(pt2FirstName);
        pt2.setMiddleName(pt2MiddleName);
        pt2.setLastName(pt2LastName);
        pt2.setDateOfBirth(pt2Dob);
        pt2.setGender(pt2Gender);
        pt2.setDeceased(pt2IsDeceased);

        assertNotEquals(pt1.getId(), pt2.getId());
        assertNotEquals(pt1.getFirstName(), pt2.getFirstName());
        assertNotEquals(pt1.getMiddleName(), pt2.getMiddleName());
        assertNotEquals(pt1.getLastName(), pt2.getLastName());
        assertNotEquals(pt1.getDateOfBirth(), pt2.getDateOfBirth());
        assertNotEquals(pt1.getGender(), pt2.getGender());
        assertNotEquals(pt1.isDeceased(), pt2.isDeceased());
        assertNotEquals(pt1.getDateDeceased(), pt2.getDateDeceased());

        assertFalse(pt2.equals(pt1));
        assertNotEquals(pt1.hashCode(), pt2.hashCode());
    }

    @Test
    public void testToString() {
        Patient pt1 = new Patient();

        pt1.setId(pt1Id);
        pt1.setFirstName(pt1FirstName);
        pt1.setMiddleName(pt1MiddleName);
        pt1.setLastName(pt1LastName);
        pt1.setDateOfBirth(pt1Dob);
        pt1.setGender(pt1Gender);
        pt1.setDeceased(pt1IsDeceased);
        pt1.setDateDeceased(pt1DateDeceased);
        pt1.setFhirId(fhirId);

        assertEquals(pt1.toString(), "Patient{id=201521, firstName=Brady, middleName=Wilson, lastName=Lynch, dateOfBirth=1958-02-02, gender=MALE, isDeceased=true, dateDeceased=2015-03-24, fhirId=f202}");
    }
}

