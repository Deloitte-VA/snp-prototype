package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.PatientWriteConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.domain.types.Race;
import org.bson.Document;
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
        LocalDate dob = LocalDate.now(); //final

        Patient patient = Mockito.mock(Patient.class);
        Mockito.when(patient.getId()).thenReturn((Long) 123l);
        Mockito.when(patient.getFirstName()).thenReturn("Jerry");
        Mockito.when(patient.getMiddleName()).thenReturn("Lee");
        Mockito.when(patient.getLastName()).thenReturn("Lewis");
        Mockito.when(patient.getDateOfBirth()).thenReturn(dob);
        Mockito.when(patient.getGender()).thenReturn(Gender.MALE);
        Mockito.when(patient.getRace()).thenReturn(Race.AMERICAN_INDIAN);

        PatientWriteConverter patientWriteConverter = new PatientWriteConverter();
        Document dbObj = patientWriteConverter.convert(patient);

        Assert.assertEquals((Long) 123l, dbObj.get(PatientTags.ID_TAG));
        Assert.assertEquals("Jerry", dbObj.get(PatientTags.FIRST_NAME_TAG));
        Assert.assertEquals("Lee", dbObj.get(PatientTags.MIDDLE_NAME_TAG));
        Assert.assertEquals("Lewis", dbObj.get(PatientTags.LAST_NAME_TAG));
        Assert.assertEquals(dob.toEpochDay(), dbObj.get(PatientTags.DATE_OF_BIRTH_TAG));
        Assert.assertEquals(Gender.MALE.getId(), dbObj.get(PatientTags.GENDER_TAG));
        Assert.assertEquals(Race.AMERICAN_INDIAN.getId(), dbObj.get(PatientTags.RACE_TAG));

    }
}


