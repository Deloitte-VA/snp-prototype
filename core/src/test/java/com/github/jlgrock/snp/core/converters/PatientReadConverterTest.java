package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PatientTags;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.DBObject;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class PatientReadConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate dob = LocalDate.ofEpochDay(12345l);

        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(PatientTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(PatientTags.FIRST_NAME_TAG)).thenReturn("Jerry");
        when(dbObj.get(PatientTags.MIDDLE_NAME_TAG)).thenReturn("Lee");
        when(dbObj.get(PatientTags.LAST_NAME_TAG)).thenReturn("Lewis");
        when(dbObj.get(PatientTags.DATE_OF_BIRTH_TAG)).thenReturn(dob.toEpochDay());
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


