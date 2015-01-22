package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.data.PatientRepository;
import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Patient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class EncounterReadConverterTest {
    @Test
    public void testConvert() {
        Date date = Mockito.mock(Date.class);
        PatientRepository patientRepository = Mockito.mock(PatientRepository.class);
        Patient patient = Mockito.mock(Patient.class);
        Mockito.when(date.getTime()).thenReturn(99999l);
        DBObject dbObject = new BasicDBObject() {{
            put("_id", 123l);
            put("patient_id", 456l);
            put("date", date);
            put("type", 1);
            put("reason_for_visit", "hernia");
        }};
        ObservationReadConverter observationReadConverter = new ObservationReadConverter();
        EncounterReadConverter encounterReadConverter = new EncounterReadConverter(observationReadConverter, patientRepository);
        Mockito.when(patientRepository.findOne(456l)).thenReturn(patient);
        Encounter encounter = encounterReadConverter.convert(dbObject);

        //Encounter encounter = observationReadConverter.convert(dbObject);
        Assert.assertEquals((Long) 123l, encounter.getId());
        Assert.assertEquals(patient, encounter.getId());
        Assert.assertEquals(date, encounter.getDate());
        Assert.assertEquals((Integer) 1, encounter.getType());
        Assert.assertEquals("hernia", encounter.getReasonForVisit());
    }


}
