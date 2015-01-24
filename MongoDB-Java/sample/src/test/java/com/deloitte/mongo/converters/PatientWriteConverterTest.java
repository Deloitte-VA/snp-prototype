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

public class PatientWriteConverterTest {

    @Test
    public void testConvert() {
        Date dob = new Date(); //can't mock because library creates a new one

        Patient patient = mock(Patient.class);
        when(patient.getId()).thenReturn((Long) 123l);
        when(patient.getFirstName()).thenReturn("Jerry");
        when(patient.getMiddleName()).thenReturn("Lee");
        when(patient.getLastName()).thenReturn("Lewis");
        when(patient.getDateOfBirth()).thenReturn(dob);
        when(patient.getGender()).thenReturn(Gender.MALE);
        when(patient.getRace()).thenReturn(Race.AMERICAN_INDIAN);

        PatientWriteConverter patientWriteConverter = new PatientWriteConverter();
        DBObject dbObj = patientWriteConverter.convert(patient);

        assertEquals((Long) 123l, dbObj.get(PatientTags.ID_TAG));
        assertEquals("Jerry", dbObj.get(PatientTags.FIRST_NAME_TAG));
        assertEquals("Lee", dbObj.get(PatientTags.MIDDLE_NAME_TAG));
        assertEquals("Lewis", dbObj.get(PatientTags.LAST_NAME_TAG));
        assertEquals(dob, dbObj.get(PatientTags.DATE_OF_BIRTH_TAG));
        assertEquals(Gender.MALE.getId(), dbObj.get(PatientTags.GENDER_TAG));
        assertEquals(Race.AMERICAN_INDIAN.getId(), dbObj.get(PatientTags.RACE_TAG));

    }
}