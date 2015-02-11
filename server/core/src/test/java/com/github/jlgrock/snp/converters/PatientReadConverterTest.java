package com.github.jlgrock.snp.converters;

import com.github.jlgrock.snp.data.PatientTags;
import com.github.jlgrock.snp.domain.Gender;
import com.github.jlgrock.snp.domain.Patient;
import com.github.jlgrock.snp.domain.Race;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PatientReadConverterTest {

    @Test
    public void testConvert() {
        DateTime dob = new DateTime(12345l);

        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(PatientTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(PatientTags.FIRST_NAME_TAG)).thenReturn("Jerry");
        when(dbObj.get(PatientTags.MIDDLE_NAME_TAG)).thenReturn("Lee");
        when(dbObj.get(PatientTags.LAST_NAME_TAG)).thenReturn("Lewis");
        when(dbObj.get(PatientTags.DATE_OF_BIRTH_TAG)).thenReturn(dob.getMillis());
        when(dbObj.get(PatientTags.GENDER_TAG)).thenReturn(Gender.MALE.getId());
        when(dbObj.get(PatientTags.RACE_TAG)).thenReturn(Race.AMERICAN_INDIAN.getId());

        PatientReadConverter patientReadConverter = new PatientReadConverter();
        Patient patient = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, patient.getId());
        assertEquals("Jerry", patient.getFirstName());
        assertEquals("Lee", patient.getMiddleName());
        assertEquals("Lewis", patient.getLastName());
        assertEquals(dob, patient.getDateOfBirth());
        assertEquals(Gender.MALE, patient.getGender());
        assertEquals(Race.AMERICAN_INDIAN, patient.getRace());
    }
}

