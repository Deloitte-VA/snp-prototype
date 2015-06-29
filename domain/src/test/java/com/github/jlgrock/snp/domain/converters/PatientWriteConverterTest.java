package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PatientWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        ObjectId objectId = ObjectId.get();
        String fName = "Jerry";
        String mName = "Lee";
        String lName = "Lewis";
        LocalDate dob = LocalDate.ofEpochDay(12345l);
        Boolean isDeceased = true;
        LocalDate dod = LocalDate.ofEpochDay(12349l);

        Patient patient = Mockito.mock(Patient.class);
        Mockito.when(patient.getId()).thenReturn(objectId);
        Mockito.when(patient.getFirstName()).thenReturn(fName);
        Mockito.when(patient.getMiddleName()).thenReturn(mName);
        Mockito.when(patient.getLastName()).thenReturn(lName);
        Mockito.when(patient.getDateOfBirth()).thenReturn(dob);
        Mockito.when(patient.getGender()).thenReturn(Gender.MALE);
        Mockito.when(patient.isDeceased()).thenReturn(isDeceased);
        Mockito.when(patient.getDateDeceased()).thenReturn(dod);

        PatientWriteConverter patientWriteConverter = new PatientWriteConverter();
        Document dbObj = patientWriteConverter.convert(patient);

        Assert.assertEquals(objectId, dbObj.get(SharedTags.ID_TAG));
        Assert.assertEquals(fName, dbObj.get(PatientTags.FIRST_NAME_TAG));
        Assert.assertEquals(mName, dbObj.get(PatientTags.MIDDLE_NAME_TAG));
        Assert.assertEquals(lName, dbObj.get(PatientTags.LAST_NAME_TAG));
        Assert.assertEquals(dob.toEpochDay(), dbObj.get(PatientTags.DATE_OF_BIRTH_TAG));
        Assert.assertEquals(Gender.MALE.getId(), dbObj.get(PatientTags.GENDER_TAG));
        Assert.assertEquals(String.valueOf(isDeceased), dbObj.get(PatientTags.DECEASED));
        Assert.assertEquals(dod.toEpochDay(), dbObj.get(PatientTags.DATE_DECEASED));

    }
}


