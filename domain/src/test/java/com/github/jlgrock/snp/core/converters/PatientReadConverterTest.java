package com.github.jlgrock.snp.core.converters;


import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.domain.types.Race;
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
        LocalDate dob = LocalDate.ofEpochDay(12345l);

        Document dbObj = Mockito.mock(Document.class);
        Mockito.when(dbObj.get(PatientTags.ID_TAG)).thenReturn(123l);
        Mockito.when(dbObj.get(PatientTags.FIRST_NAME_TAG)).thenReturn("Jerry");
        Mockito.when(dbObj.get(PatientTags.MIDDLE_NAME_TAG)).thenReturn("Lee");
        Mockito.when(dbObj.get(PatientTags.LAST_NAME_TAG)).thenReturn("Lewis");
        Mockito.when(dbObj.get(PatientTags.DATE_OF_BIRTH_TAG)).thenReturn(dob.toEpochDay());
        Mockito.when(dbObj.get(PatientTags.GENDER_TAG)).thenReturn(Gender.MALE.getId());
        Mockito.when(dbObj.get(PatientTags.RACE_TAG)).thenReturn(Race.AMERICAN_INDIAN.getId());

        PatientReadConverter patientReadConverter = new PatientReadConverter();
        Patient patient = patientReadConverter.convert(dbObj);

        Assert.assertEquals((Long) 123l, patient.getId());
        Assert.assertEquals("Jerry", patient.getFirstName());
        Assert.assertEquals("Lee", patient.getMiddleName());
        Assert.assertEquals("Lewis", patient.getLastName());
        Assert.assertEquals(dob, patient.getDateOfBirth());
        Assert.assertEquals(Gender.MALE, patient.getGender());
//        Assert.assertEquals(Race.AMERICAN_INDIAN, patient.getRace());
    }
}


