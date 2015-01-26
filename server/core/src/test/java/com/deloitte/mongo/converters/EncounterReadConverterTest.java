package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.EncounterTags;
import com.deloitte.mongo.data.PatientRepository;
import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.Patient;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EncounterReadConverterTest {

    @Test
    public void testConvert() {
        Date date = mock(Date.class);
        Patient patient = mock(Patient.class);
        when(date.getTime()).thenReturn(99999l);

        Observation observation1 = mock(Observation.class);
        Observation observation2 = mock(Observation.class);
        List<Observation> observations = new ArrayList() {{
            add(observation1);
            add(observation1);
            add(observation2);
        }};
        DBObject observation1Obj = mock(BasicDBObject.class);
        DBObject observation2Obj = mock(BasicDBObject.class);
        BasicDBList observationObjs = new BasicDBList() {{
            add(observation1Obj);
            add(observation1Obj);
            add(observation2Obj);
        }};
        ObservationReadConverter observationReadConverter = mock(ObservationReadConverter.class);

        DBObject dbObject = new BasicDBObject() {{
            put(EncounterTags.ID_TAG, 123l);
            put(EncounterTags.PATIENT_TAG, 456l);
            put(EncounterTags.DATE_TAG, date);
            put(EncounterTags.TYPE_TAG, 1);
            put(EncounterTags.REASON_FOR_VISIT_TAG, "hernia");
            put(EncounterTags.OBSERVATIONS_TAG, observationObjs);
        }};

        when(observationReadConverter.convert(observation1Obj)).thenReturn(observation1);
        when(observationReadConverter.convert(observation2Obj)).thenReturn(observation2);

        PatientRepository patientRepository = mock(PatientRepository.class);
        when(patientRepository.findOne(456l)).thenReturn(patient);

        EncounterReadConverter encounterReadConverter = new EncounterReadConverter(observationReadConverter, patientRepository);

        Encounter encounter = encounterReadConverter.convert(dbObject);
        assertEquals((Long) 123l, encounter.getId());
        assertEquals(patient, encounter.getPatient());
        assertEquals(date, encounter.getDate());
        assertEquals((Integer) 1, encounter.getType());
        assertEquals("hernia", encounter.getReasonForVisit());
        assertEquals(observations, encounter.getObservations());
    }


}
