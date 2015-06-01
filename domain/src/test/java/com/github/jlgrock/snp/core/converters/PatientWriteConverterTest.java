package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PatientTags;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import org.bson.Document;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class PatientWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate dob = LocalDate.now(); //final

        Patient patient = mock(Patient.class);
        when(patient.getId()).thenReturn((Long) 123l);
        when(patient.getFirstName()).thenReturn("Jerry");
        when(patient.getMiddleName()).thenReturn("Lee");
        when(patient.getLastName()).thenReturn("Lewis");
        when(patient.getDateOfBirth()).thenReturn(dob);
        when(patient.getGender()).thenReturn(Gender.MALE);
        when(patient.getRace()).thenReturn(Race.AMERICAN_INDIAN);

        PatientWriteConverter patientWriteConverter = new PatientWriteConverter();
        Document dbObj = patientWriteConverter.convert(patient);

        assertEquals((Long) 123l, dbObj.get(PatientTags.ID_TAG));
        assertEquals("Jerry", dbObj.get(PatientTags.FIRST_NAME_TAG));
        assertEquals("Lee", dbObj.get(PatientTags.MIDDLE_NAME_TAG));
        assertEquals("Lewis", dbObj.get(PatientTags.LAST_NAME_TAG));
        assertEquals(dob.toEpochDay(), dbObj.get(PatientTags.DATE_OF_BIRTH_TAG));
        assertEquals(Gender.MALE.getId(), dbObj.get(PatientTags.GENDER_TAG));
        assertEquals(Race.AMERICAN_INDIAN.getId(), dbObj.get(PatientTags.RACE_TAG));

    }
}


