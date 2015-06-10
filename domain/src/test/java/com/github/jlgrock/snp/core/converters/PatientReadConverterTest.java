package com.github.jlgrock.snp.core.converters;


import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PatientReadConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Long id = 123l;
        String fName = "Jerry";
        String mName = "Lee";
        String lName = "Lewis";
        LocalDate dob = LocalDate.ofEpochDay(23456l);
        Boolean isDeceased = true;
        LocalDate dod = LocalDate.ofEpochDay(23490l);

        Document dbObj = Mockito.mock(Document.class);
        Mockito.when(dbObj.get(SharedTags.ID_TAG)).thenReturn(id);
        Mockito.when(dbObj.get(PatientTags.FIRST_NAME_TAG)).thenReturn(fName);
        Mockito.when(dbObj.get(PatientTags.MIDDLE_NAME_TAG)).thenReturn(mName);
        Mockito.when(dbObj.get(PatientTags.LAST_NAME_TAG)).thenReturn(lName);
        Mockito.when(dbObj.get(PatientTags.DATE_OF_BIRTH_TAG)).thenReturn(dob.toEpochDay());
        Mockito.when(dbObj.get(PatientTags.GENDER_TAG)).thenReturn(Gender.MALE.getId());
        Mockito.when(dbObj.get(PatientTags.DECEASED)).thenReturn(String.valueOf(isDeceased));
        Mockito.when(dbObj.get(PatientTags.DATE_DECEASED)).thenReturn(dod.toEpochDay());

        PatientReadConverter patientReadConverter = new PatientReadConverter();
        Patient patient = patientReadConverter.convert(dbObj);

        Assert.assertEquals(id, patient.getId());
        Assert.assertEquals(fName, patient.getFirstName());
        Assert.assertEquals(mName, patient.getMiddleName());
        Assert.assertEquals(lName, patient.getLastName());
        Assert.assertEquals(dob, patient.getDateOfBirth());
        Assert.assertEquals(Gender.MALE, patient.getGender());
        Assert.assertEquals(isDeceased, patient.isDeceased());
        Assert.assertEquals(dod, patient.getDateDeceased());
    }
}


