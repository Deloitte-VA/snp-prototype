package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.PatientTags;
import com.deloitte.mongo.domain.Gender;
import com.deloitte.mongo.domain.Patient;
import com.deloitte.mongo.domain.Race;
import com.mongodb.DBObject;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PatientReadConverterTest {

    @Test
    public void testConvert() {
        Date dob = new Date(12345l);

        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(PatientTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(PatientTags.FIRST_NAME_TAG)).thenReturn("Jerry");
        when(dbObj.get(PatientTags.MIDDLE_NAME_TAG)).thenReturn("Lee");
        when(dbObj.get(PatientTags.LAST_NAME_TAG)).thenReturn("Lewis");
        when(dbObj.get(PatientTags.DATE_OF_BIRTH_TAG)).thenReturn(dob.getTime());
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