package com.deloitte.mongo.converters

import com.deloitte.mongo.domain.Encounter
import com.deloitte.mongo.domain.Observation
import com.deloitte.mongo.domain.Patient
import com.mongodb.BasicDBList
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


class EncounterWriteConverterTest extends GroovyTestCase {
    @Test
    public void testConvert() {
        Date date = mock(Date.class);
        Patient patient = mock(Patient.class);
        when(patient.getId()).thenReturn((Long) 456l);

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
        ObservationWriteConverter observationWriteConverter = mock(ObservationWriteConverter.class);
        when(observationWriteConverter.convert(observation1)).thenReturn(observation1Obj);
        when(observationWriteConverter.convert(observation2)).thenReturn(observation2Obj);

        Encounter encounter = mock(Encounter.class);
        when(encounter.getId()).thenReturn((Long) 123l);
        when(encounter.getDate()).thenReturn(date);
        when(encounter.getPatient()).thenReturn(patient);
        when(encounter.getReasonForVisit()).thenReturn("hernia");
        when(encounter.getType()).thenReturn(1);
        when(encounter.getObservations()).thenReturn(observations);

        EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(observationWriteConverter);
        DBObject dbObj = encounterWriteConverter.convert(encounter);

        assertEquals((Long) 123l, dbObj.get(EncounterTags.ID_TAG));
        assertEquals(date, dbObj.get(EncounterTags.DATE_TAG));
        assertEquals((Long) 456l, dbObj.get(EncounterTags.PATIENT_TAG));
        assertEquals("hernia", dbObj.get(EncounterTags.REASON_FOR_VISIT_TAG));
        assertEquals(1, dbObj.get(EncounterTags.TYPE_TAG));
        assertEquals(observationObjs, dbObj.get(EncounterTags.OBSERVATIONS_TAG));
    }
}
